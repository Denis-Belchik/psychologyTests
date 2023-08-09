package com.setlocal.psychologyTests.security;

import com.setlocal.psychologyTests.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
public class PersonDetails implements UserDetails {

    private final PersonDTO personDTO;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(personDTO.getRole().name()));
    }

    @Override
    public String getPassword() {
        return personDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return personDTO.getUsername();
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
        return personDTO.isEnabled();
    }

    public PersonDTO getPersonDTO(){
        return this.personDTO;
    }
}
