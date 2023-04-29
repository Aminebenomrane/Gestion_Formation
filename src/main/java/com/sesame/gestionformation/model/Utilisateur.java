package com.sesame.gestionformation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sesame.gestionformation.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public   class  Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy= IDENTITY)

    private Integer id_user;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "age")
    private int age;

    @Column(name="date_naissance")
    private Date naissance;
    @Column(name = "email")
    private String email;

    private int telephone;
    @Column(name="pays")
    private String pays;
    @Column(name = "pseudo")
    private String pseudo;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
private List<Token>tokens;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
