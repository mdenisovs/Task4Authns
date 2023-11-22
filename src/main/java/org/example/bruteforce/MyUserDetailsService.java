package org.example.bruteforce;

import org.example.data.entities.Authority;
import org.example.data.entities.User;
import org.example.data.repository.RoleRepository;
import org.example.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (loginAttemptService.isBlocked()) {
            throw new RuntimeException("blocked");
        }

        try {
            var user = userRepository.findByName(email);

            if (user == null) {
                return new org.springframework.security.core.userdetails.User(
                        " ", " ", true, true, true, true,
                        getAuthorities(Set.of(new Authority())));
            }

            var auth = roleRepository.findByUsername(user.getName());
            return new org.springframework.security.core.userdetails.User(
                    user.getName(), user.getPassword(), user.getEnabled(), true, true, true,
                    getAuthorities(auth));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<GrantedAuthority> getAuthorities(Set<Authority> userRoles) {
        return userRoles.stream()
                .map(it -> new SimpleGrantedAuthority(it.getAuthority()))
                .collect(Collectors.toList());
    }
}