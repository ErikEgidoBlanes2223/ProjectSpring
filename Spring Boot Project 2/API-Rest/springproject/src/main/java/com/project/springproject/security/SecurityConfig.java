package com.project.springproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Configuración de la autenticación
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user1").password(passwordEncoder().encode("password1")).roles("USER")
            .and()
            .withUser("admin1").password(passwordEncoder().encode("adminpassword1")).roles("USER", "ADMIN");
    }

    // Configuración de la autorización y otros aspectos de seguridad
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/public/**").permitAll() // Rutas públicas permitidas a todos
            .antMatchers("/admin/**").hasRole("ADMIN") // Rutas de administrador requerirán rol ADMIN
            .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
            .and()
            .formLogin().loginPage("/login").permitAll() // Configuración de inicio de sesión personalizado en /login
            .and()
            .logout().permitAll(); // Configuración de cierre de sesión permitido
    }

    // Configuración del codificador de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
