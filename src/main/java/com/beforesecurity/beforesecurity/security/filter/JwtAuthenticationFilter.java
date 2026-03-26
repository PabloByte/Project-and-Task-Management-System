package com.beforesecurity.beforesecurity.security.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.beforesecurity.beforesecurity.model.UserAccount;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.beforesecurity.beforesecurity.security.TokenJwtConfig;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.beforesecurity.beforesecurity.security.TokenJwtConfig.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.security.Message;


public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


        private final AuthenticationManager authenticationManager;
   


        public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
                this.authenticationManager = authenticationManager;
        }

        @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {


                                UserAccount userAccount = null;
                                String userName = null;
                                String password = null;

                                try {

                                        userAccount = new ObjectMapper().readValue(request.getInputStream(), UserAccount.class);
                                        userName = userAccount.getUserName();
                                        password = userAccount.getPassword();

                                } catch (StreamReadException e) {

                                        
                                        e.printStackTrace();

                                } catch (DatabindException e) {
                                        
                                        e.printStackTrace();
                                } catch (IOException e) {
                                       
                                        e.printStackTrace();
                                }
                                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
                                return authenticationManager.authenticate(authenticationToken);
        
        }

        @Override
        protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

                 User user = (User) authResult.getPrincipal();      
                 String userName = user.getUsername();
                 
                 Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();
                 
                 Claims claimsUser = Jwts.claims()
                   .add("authorities", new ObjectMapper().writeValueAsString(roles)) // esto lo debo modificar en el paso implementando filtro para validar el token 
                   .add("userName",userName)
                   .build();
                 

                 String token = Jwts.builder()
                 .claims(claimsUser)
                 .subject(userName)
                 .expiration(new Date(System.currentTimeMillis() + 3600000))
                 .issuedAt(new Date())
                 .signWith(SECRECT_KEY)
                 .compact();

                 response.addHeader(HEADER_AUTHORIZATION,PREFIX_TOKEN + token);

                Map<String, String> body = new  HashMap<>();

                body.put("token", token);
                body.put("UserName", userName);
                body.put("message", "Ha iniciado sesion exitosamente");

                response.getWriter().write(new ObjectMapper().writeValueAsString(body));
                response.setStatus(200);
                response.setContentType(CONTENT_TYPE);





        }

        

        @Override
        protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                        AuthenticationException failed) throws IOException, ServletException {

              Map<String, String> body = new HashMap<>();
              body.put("message", "No pudimos validar sus credenciales de inicio de sesion");
              body.put("error", failed.getMessage());
              
              response.getWriter().write(new ObjectMapper().writeValueAsString(body));
              response.setStatus(401);
              response.setContentType(CONTENT_TYPE);
        }

        





        

}
