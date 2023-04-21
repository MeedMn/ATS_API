package com.example.gestiondriver.authentification

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class RegisterRequest (
        val firstname: String,
        val lastname: String,
        val email: String,
        val password: String
)