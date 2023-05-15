package com.example.gestiondriver.authentification

import com.example.gestiondriver.Model.Role
import com.example.gestiondriver.Services.AuthService
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Tes
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
class AuthentificationController(private val service: AuthService) {

    @PostMapping("/register/{role}")
    fun register(@RequestBody request: RegisterRequest,@PathVariable role:String): ResponseEntity<AuthResponse> {
        if(role.equals("ADMIN"))
            return ResponseEntity.ok(service.register(request,Role.ADMIN))
        else if(role.equals("PARENT"))
            return ResponseEntity.ok(service.register(request,Role.PARENT))
        else
            return ResponseEntity.ok(service.register(request,Role.DRIVER))
    }

    @PostMapping("/authentificate")
    fun authenticate(@RequestBody request: AuthRequest): ResponseEntity<AuthResponse> {
        try {
            val authResponse = service.authenticate(request)
            return ResponseEntity.ok(authResponse)
        } catch (ex:Exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(AuthResponse("This user ${request.email} doesn't exist"))
        }
    }

}