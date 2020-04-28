package io.lab.springdatalab.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

public class JwtFilter extends BasicAuthenticationFilter {

    public JwtFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader("Authorization");
        UsernamePasswordAuthenticationToken authResult = getAuthByToken(header);

        SecurityContextHolder.getContext().setAuthentication(authResult);

        chain.doFilter(request,response);
    }

    private UsernamePasswordAuthenticationToken getAuthByToken(String header) {

        System.out.println(header);
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET)
                    .parseClaimsJws(header.replace(SecurityConstants.TOKEN_PREFIX, ""));


        String username = claimsJws.getBody().get("name").toString();
        String password = claimsJws.getBody().get("password").toString();
        String role = claimsJws.getBody().get("role").toString();


        Set<SimpleGrantedAuthority> simpleGrantedAuthoritySet = Collections.singleton(new SimpleGrantedAuthority(role));

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,password,simpleGrantedAuthoritySet);

        return usernamePasswordAuthenticationToken;
    }


}
