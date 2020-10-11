package com.project.lgnscrt.security;

import com.project.lgnscrt.entity.User;
import com.project.lgnscrt.service.UserService;
import io.fusionauth.jwt.JWTException;
import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACVerifier;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;

public class VerifyTokenFilter{

    private final UserService userService;

    public VerifyTokenFilter(UserService userService) {
        this.userService = userService;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.isEmpty(header) && header.startsWith(JwtProperties.TOKEN_PREFIX)) {

            String jwtToken = header.substring(JwtProperties.TOKEN_PREFIX.length());
            Verifier verifier = HMACVerifier.newVerifier(JwtProperties.SECRET);
            try {
                JWT jwt = JWT.getDecoder().decode(jwtToken, verifier);
                String email = jwt.getString("sub");
                User user = null;
                user = userService.findByEmail(email);
                UserAuthentication userAuthentication = new UserAuthentication(true, user, Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString())));
                SecurityContextHolder.getContext().setAuthentication(userAuthentication);

            } catch (JWTException ignored) {
                ignored.getStackTrace();
            }
        }
        chain.doFilter(request, response);
    }
}
