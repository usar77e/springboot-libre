package cl.javaguides.springsecurity.service;

import cl.javaguides.springsecurity.model.User;
import cl.javaguides.springsecurity.repository.UserRepository;
import cl.javaguides.springsecurity.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("usuario no encontrado");
        }
        return new CustomUserDetails(user);
    }
}
