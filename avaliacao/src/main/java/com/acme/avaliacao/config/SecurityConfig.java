package com.acme.avaliacao.config;

//import com.acme.avaliacao.security.JwtConverter;
import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;


@RequiredArgsConstructor
public class SecurityConfig {
 //   private final JwtConverter jwtConverter;
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((authz) ->{
//                    authz
//                            .requestMatchers("/hello").permitAll()
//                            .requestMatchers("/**").hasRole("ADMIN")
//                            .requestMatchers("/avaliacao").hasAnyRole("ADMIN","USER")
//                            .anyRequest().permitAll();
//
//                });
//                http.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtConverter)));
//                return http.build();
//
//    }
}
