package com.hackthenorth.priceisthegoat.configurations;

import com.hackthenorth.priceisthegoat.converter.RegistrationDTOToUserConverter;
import com.hackthenorth.priceisthegoat.converter.UserToUserDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    private final HTNUserDetailService userDetailsService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.requiresChannel()
            .requestMatchers(request -> request.getHeader("X-Forwarded-Proto") != null)
            .requiresSecure();
    }

    // Beans
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(encoder());
        authProvider.setUserDetailsService(userDetailsService);
        return authProvider;
    }

    @Override
    public void addFormatters(final FormatterRegistry mvcConversionService) {
        mvcConversionService.addConverter(new UserToUserDTOConverter());
        mvcConversionService.addConverter(new RegistrationDTOToUserConverter());
    }
}
