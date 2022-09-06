package com.example.movie.dao.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@EntityListeners(AuditingEntityListener.class)
public class SysUserEntity implements UserDetails {
    private static final long serialVersionUID = 4522943071576672084L;

    @Id
    @Column(name = "id" )
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;

    private String username;
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SysUserEntity){
            return ((SysUserEntity) obj).getUsername().equals(this.username);
        }else {
            return false;
        }
    }

}
