package com.beforesecurity.beforesecurity.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.beforesecurity.beforesecurity.security.filter.JwtAuthenticationFilter;
import com.beforesecurity.beforesecurity.security.filter.JwtValidationFilter;

import io.jsonwebtoken.lang.Arrays;



@Configuration
@EnableMethodSecurity(prePostEnabled=true)
public class SpringSecurityConfig {

        @Autowired
        private AuthenticationConfiguration authenticationConfiguration;

        @Bean
        AuthenticationManager authenticationManager()throws Exception{

           return authenticationConfiguration.getAuthenticationManager();     

        }

@Bean  // agrego esto para que sea un componente       
PasswordEncoder passwordEncoder (){

return new BCryptPasswordEncoder();

}



@Bean
SecurityFilterChain filterChain (HttpSecurity http) throws Exception{

        return http.authorizeHttpRequests((authz) -> authz  


                        // ==============================
                    // MODIFICADO: rutas públicas frontend
                    // ==============================
                    .requestMatchers("/pages/login.html").permitAll()
                    .requestMatchers("/pages/dashboard.html").permitAll()
                    .requestMatchers("/css/**").permitAll()
                    .requestMatchers("/js/**").permitAll()
                    .requestMatchers("/images/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/login").permitAll()

                    // ==============================
                    // IMPORTANTE:
                    // deja público también el endpoint de login
                    // AJUSTA esta ruta si tu JwtAuthenticationFilter usa otra
                    // ==============================


                .requestMatchers(HttpMethod.POST,"/UserAccount/register").permitAll() // creacion de cuentas

                .requestMatchers(HttpMethod.POST,"/project/createProject").hasRole("ADMINISTRATOR")
                .requestMatchers(HttpMethod.GET,"/project/ShowAll").hasAnyRole("USER","ADMINISTRATOR")
                .requestMatchers(HttpMethod.GET,"/project/findById/{id}").hasAnyRole("USER","ADMINISTRATOR")
                .requestMatchers(HttpMethod.PUT,"/project/update/{id}").hasRole("ADMINISTRATOR")
                .requestMatchers(HttpMethod.DELETE,"/project/deleteProject/{id}").hasRole("ADMINISTRATOR")



                .requestMatchers(HttpMethod.POST,"/collaborator/create").hasAnyRole("USER","ADMINISTRATOR")
                .requestMatchers(HttpMethod.GET,"/collaborator/showAll").hasAnyRole("USER","ADMINISTRATOR")
                .requestMatchers(HttpMethod.GET,"/collaborator/findById/{id}").hasAnyRole("USER","ADMINISTRATOR")
                .requestMatchers(HttpMethod.DELETE,"/collaborator/deleteById/{id}").hasRole("ADMINISTRATOR")
                .requestMatchers(HttpMethod.PUT,"/collaborator/Update/{id}").hasRole("ADMINISTRATOR")



                 .requestMatchers(HttpMethod.POST,"/task/create").hasAnyRole("USER","ADMINISTRATOR")
                 .requestMatchers(HttpMethod.GET,"/task/{id}/download").hasAnyRole("USER","ADMINISTRATOR")

                .requestMatchers(HttpMethod.GET,"/UserAccount/showAccounts").hasRole("ADMINISTRATOR")
                .anyRequest().authenticated())


                .addFilter(new JwtAuthenticationFilter(authenticationManager())) // FILTRO DE AUTENTICACION
                .addFilter(new JwtValidationFilter(authenticationManager())) //FILTRO DE VALIDACION

                .csrf(config -> config.disable())

                .cors(cors -> cors.configurationSource(corsConfigurationSource()))// lo agrego en configurando cors para los clientes

                .sessionManagement (management -> 
                        management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                



            


                .build();
                
        
}




// lo agrego en configurando cors para los clientes 
@Bean
CorsConfigurationSource corsConfigurationSource() {

  CorsConfiguration config = new CorsConfiguration();

  config.setAllowedOriginPatterns(java.util.Arrays.asList("*"));
  config.setAllowedMethods(java.util.Arrays.asList("GET", "POST", "DELETE", "PUT"));
  config.setAllowedHeaders(java.util.Arrays.asList("Authorization", "Content-Type"));
  config.setAllowCredentials(true);

  UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
  source.registerCorsConfiguration("/**",config);
  return source;

}

// lo agrego en configurando cors para los clientes, este metodo intercepta todas las peticiones http y aplica la configuracion de cors
@Bean
FilterRegistrationBean<org.springframework.web.filter.CorsFilter> corsFilter (){

FilterRegistrationBean<org.springframework.web.filter.CorsFilter> corsBean = new FilterRegistrationBean<>(new org.springframework.web.filter.CorsFilter(corsConfigurationSource()));


corsBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
return  corsBean;
}








}
