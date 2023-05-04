package com.pragma.plaza_comida.infrastructure.configuration;

import com.pragma.plaza_comida.application.dto.request.UserRequestDto;
import com.pragma.plaza_comida.application.handler.IJwtHandler;
import com.pragma.plaza_comida.application.mapper.request.IUserRequestMapper;
import com.pragma.plaza_comida.domain.model.UserModel;
import com.pragma.plaza_comida.infrastructure.input.rest.Client.IUserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final IJwtHandler jwtHandler;
    private final UserDetailsService userDetailsService;
    private final IUserClient userRepository;

    private final IUserRequestMapper iUserRequestMapper;
    private final IUserEntityMapper iUserEntityMapper;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        userEmail = jwtHandler.extractUserName(jwt);
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserRequestDto user = userRepository.getUserByEmail(userEmail).getBody().getData();
            UserModel userModel = iUserRequestMapper.toUser(user);
            UserEntity userEntity = iUserEntityMapper.toEntity(userModel);
            UserDetails userDetails = userEntity;
            if (jwtHandler.isTokenValid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

}