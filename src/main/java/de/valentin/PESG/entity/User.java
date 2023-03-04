package de.valentin.PESG.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data //Generiert Getter und Setter und überschreibt die Standard Java-Objektmethoden, wie equals()
@Builder //Generiert eine innere Klasse, um ein Objekt der Klasse zu erstellen. User.builder().firstname...
@NoArgsConstructor //Generiert einen Konstruktor ohne Werte
@AllArgsConstructor //Konstruktor mit Werte
@Entity //Es ist eine JPA-Entität (Tabelle)
@Table(name="_User") //Tabelle genauer Beschreiben
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String email;

    private String password;

    private String firstname;

    private String lastname;

    private LocalDateTime lastUpload;

    @OneToMany(mappedBy = "user")
    private List<Link> links;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return null;
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
