package com.example.gestiondriver.config

import com.example.gestiondriver.Repository.TokenRepository
import com.example.gestiondriver.Services.JwtService
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import lombok.RequiredArgsConstructor
import org.springframework.lang.NonNull
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Component
@RequiredArgsConstructor
class JwtAuth(
    private val jwtService: JwtService,
    private val userDetailsService: UserDetailsService,
    private val tokenRepository: TokenRepository
) : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
            @NonNull request: HttpServletRequest,
            @NonNull response: HttpServletResponse,
            @NonNull filterChain: FilterChain
    ) {
        val authHeader = request.getHeader("Authorization")
        val jwt: String?
        val userEmail: String?
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }
        jwt = authHeader.substring(7)
        userEmail = jwtService.extractUsername(jwt)
        if (userEmail != null && SecurityContextHolder.getContext().authentication == null) {
            val userDetails = try {
                userDetailsService.loadUserByUsername(userEmail)
            } catch (e: UsernameNotFoundException) {
                filterChain.doFilter(request, response)
                return
            }
            val isTokenValid = tokenRepository.findByToken(jwt)
                    .map { !it.expired && !it.revoked }
                    .orElse(false)
            if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
                val authToken = UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.authorities
                )
                authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authToken
            }
        }
        filterChain.doFilter(request, response)
    }
}