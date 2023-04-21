package com.example.gestiondriver.Services

import com.example.gestiondriver.Repository.TokenRepository
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LogoutService(private val tokenRepository: TokenRepository) : LogoutHandler {

    override fun logout(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {
        val authHeader: String? = request.getHeader("Authorization")
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return
        }
        val jwt: String = authHeader.substring(7)
        val storedToken = tokenRepository.findByToken(jwt).orElse(null)
        if (storedToken != null) {
            storedToken.expired = true
            storedToken.revoked = true
            tokenRepository.save(storedToken)
            SecurityContextHolder.clearContext()
        }
    }
}