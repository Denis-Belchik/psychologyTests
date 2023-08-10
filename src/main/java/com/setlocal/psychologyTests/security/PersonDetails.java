package com.setlocal.psychologyTests.security;

import com.setlocal.psychologyTests.dto.PersonForRegDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
public class PersonDetails implements UserDetails {

    private final PersonForRegDTO personForRegDTO;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(personForRegDTO.getRole().name()));
    }

    @Override
    public String getPassword() {
        return personForRegDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return personForRegDTO.getUsername();
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
        return personForRegDTO.isEnabled();
    }

    public PersonForRegDTO getPersonForRegDTO(){
        return this.personForRegDTO;
    }
}
