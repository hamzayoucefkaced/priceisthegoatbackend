package com.hackthenorth.priceisthegoat.configurations;

import com.hackthenorth.priceisthegoat.converter.DogToDogDTOConverter;
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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    private static final String FRONTEND_URL       = "https://htn2021frontend.herokuapp.com/";
    private static final String LOCAL_FRONTEND_URL = "http://localhost:3000";

    private final HTNUserDetailService userDetailsService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.requiresChannel()
            .requestMatchers(request -> request.getHeader("X-Forwarded-Proto") != null)

            .requiresSecure();

        http.cors()
            .and()
            .authorizeRequests()
            .antMatchers("/register").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/api").permitAll()
            .and()
            .formLogin().disable()
            .logout()
            .permitAll()
            .logoutUrl("/logout")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .and()
            .csrf().disable();
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
        mvcConversionService.addConverter(new DogToDogDTOConverter());
        mvcConversionService.addConverter(new UserToUserDTOConverter());
    }

    @Bean
    static CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(LOCAL_FRONTEND_URL, FRONTEND_URL));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
        configuration.setExposedHeaders(Arrays.asList("Authorization", "content-type"));
        configuration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
        configuration.setAllowCredentials(true);
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
