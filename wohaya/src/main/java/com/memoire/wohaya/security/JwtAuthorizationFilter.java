package com.memoire.wohaya.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.memoire.wohaya.domaine.Utilisateur;
import com.memoire.wohaya.repository.UtilisateurRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final UtilisateurRepository utilisateurRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UtilisateurRepository utilisateurRepository) {
        super(authenticationManager);
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        //Read the Authorization filter where the JWT  token should be
        String header = request.getHeader(JwtProperties.HEADER_STRING);

        //if header does not contain Bearer or is null delegate to Spring impl and exit
        if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)){
            chain.doFilter(request, response);
            return;
        }

        //If header is present try grab user principal from database and perform authorization
        Authentication authentication = getUserPasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Continue filter execution
        chain.doFilter(request, response);
    }

    private Authentication getUserPasswordAuthentication(HttpServletRequest request) {

        String token = request.getHeader(JwtProperties.HEADER_STRING);
        if (token != null){
            //parse the token and validate it
            String userName = JWT
                    .require(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(JwtProperties.TOKEN_PREFIX, ""))
                    .getSubject();

            //Search in the DB if we find the user by token subject(username)
            //If so, then grab user details and create spring auth token using username, pass, authorities, roles
            if (userName != null){
                Utilisateur utilisateur = utilisateurRepository.findByUsername(userName);
                UserPrincipal principal = new UserPrincipal(utilisateur);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, null, principal.getAuthorities());
                return authenticationToken;
            }
            return  null;
        }
        return null;
    }

}
