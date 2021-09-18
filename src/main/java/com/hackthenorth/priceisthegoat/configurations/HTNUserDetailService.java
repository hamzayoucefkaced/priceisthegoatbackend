package com.hackthenorth.priceisthegoat.configurations;

import com.hackthenorth.priceisthegoat.dal.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HTNUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        return new HTNUserDetails(userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username)));
    }
}
