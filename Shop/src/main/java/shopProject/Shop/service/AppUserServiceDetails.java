package shopProject.Shop.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import shopProject.Shop.entity.UserEntity;
import shopProject.Shop.repository.UserRepository;

@Service
public class AppUserServiceDetails implements UserDetailsService {
d
    private final UserRepository userRepository;

    @Autowired
    public AppUserServiceDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity existingUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found: " + email));

        return new org.springframework.security.core.userdetails.User(
                existingUser.getEmail(),
                existingUser.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(existingUser.getRole()))
        );
    }
}
