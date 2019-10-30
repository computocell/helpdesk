package br.com.computocell.helpdesk.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.computocell.helpdesk.api.security.entity.User;
import br.com.computocell.helpdesk.api.security.jwt.JwtUserFactory;
import br.com.computocell.helpdesk.api.service.UserService;

/**
 * Usado para manipular a interface do User Details
 */
@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {
	
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("No User found with username '%s'.",email));
        }else
        {
            return JwtUserFactory.create(user);
        }

    }
}
