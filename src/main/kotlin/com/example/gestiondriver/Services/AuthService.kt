package com.example.gestiondriver.Services

import com.example.gestiondriver.Model.Role
import com.example.gestiondriver.Model.User
import com.example.gestiondriver.Repository.TokenRepository
import com.example.gestiondriver.Repository.UserRepository
import com.example.gestiondriver.authentification.AuthRequest
import com.example.gestiondriver.authentification.AuthResponse
import com.example.gestiondriver.authentification.RegisterRequest
import com.example.gestiondriver.token.Token
import com.example.gestiondriver.token.Type
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import kotlin.jvm.Throws

@Service
@RequiredArgsConstructor
class AuthService(
    private val repository: UserRepository,
    private val tokenRepository: TokenRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
) {

    fun register(request: RegisterRequest,role:Role): AuthResponse {
        val user = User(
                firstname = request.firstname,
                lastname = request.lastname,
                email = request.email,
                password = passwordEncoder.encode(request.password),
                role = role
        )
        val savedUser = repository.save(user)
        val jwtToken = jwtService.generateToken(user)
        saveUserToken(savedUser, jwtToken)
        return AuthResponse(token = jwtToken)
    }

    fun authenticate(request: AuthRequest): AuthResponse {
        authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        request.email,
                        request.password
                )
        )
        val user = repository.findByEmail(request.email)
                .orElseThrow { throw Exception("User not found with email: ${request.email}") }
        val jwtToken = jwtService.generateToken(user)
        revokeAllUserTokens(user)
        saveUserToken(user, jwtToken)
        return AuthResponse(token = jwtToken)
    }
    private fun saveUserToken(user: User, jwtToken: String) {
        val token = Token(user = user, token = jwtToken, tokenType = Type.BEARER,expired = false,revoked = false)
        tokenRepository.save(token)
    }
    private fun revokeAllUserTokens(user: User) {
        val validUserTokens = ArrayList<Token>()
        for (token in tokenRepository.findAll()) {
            if (token.user.id == user.id && !token.expired) {
                validUserTokens.add(token)
            }
        }
        if (validUserTokens.isEmpty()) {
            return
        }
        for (token in validUserTokens) {
            token.expired = true
            token.revoked = true
            tokenRepository.save(token)
        }
    }
}