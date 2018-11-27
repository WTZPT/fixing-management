package org.project.security;

import org.project.entity.User;
import org.project.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @Author weitangzhao
 **/
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String passwordInput = (String) authentication.getCredentials();

        User user = userService.findUserByName(username);
        if(user == null){
            //找不到AuthenticationCredentials
            throw new AuthenticationCredentialsNotFoundException("authError");
        }


        if(user.getPassword().equals(passwordInput)){
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        }
        //坏的凭据
        throw new BadCredentialsException("authError");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
