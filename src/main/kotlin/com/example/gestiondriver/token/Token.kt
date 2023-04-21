package com.example.gestiondriver.token


import com.example.gestiondriver.Model.User
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
class Token(
    @Id
    @GeneratedValue
    var id: Int = 0,
    @Column(unique = true)
    var token: String = "",
    @Enumerated(EnumType.STRING)
    var tokenType: Type = Type.BEARER,
    var revoked: Boolean = false,
    var expired: Boolean = false,
    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User = User()
)