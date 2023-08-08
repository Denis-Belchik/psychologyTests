package com.setlocal.psychologyTests.security;

import com.setlocal.psychologyTests.dto.PersonDTO;
import com.setlocal.psychologyTests.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@RequiredArgsConstructor
public class PersonDetails implements UserDetails {

    private final PersonDTO personDTO;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
        return personDTO.getEnabled() == 1;
    }

    public PersonDTO getPersonDTO(){
        return this.personDTO;
    }
}
