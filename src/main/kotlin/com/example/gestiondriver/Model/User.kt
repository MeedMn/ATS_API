package com.example.gestiondriver.Model

import com.example.gestiondriver.token.Token
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
class User(
        @Id
        @GeneratedValue
        var id: Int=0,
        var firstname: String="",
        var lastname: String="",
        private var email: String="",
        private var password: String="",
        @Enumerated(EnumType.STRING)
        var role: Role?=null,
        @OneToMany(mappedBy = "user")
        var tokens: List<Token>?=null
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(role!!.name))
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return email
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return this.password
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}