package com.example.playroom.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.example.playroom.component.CustomAuthenticationProvider;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomAuthenticationProvider customAuthenticationProvider;

    public SecurityConfig(CustomAuthenticationProvider customAuthenticationProvider){
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authenticationProvider(customAuthenticationProvider)
                .addFilterBefore(new CustomFilter(), UsernamePasswordAuthenticationFilter.class)
                // CORSの設定を適用
                .cors(customizer -> customizer.configurationSource(corsConfigurationSource()))
                // CSRFの保護を無効にする
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin((login) -> login
                        // 認証時のリクエストURL
                        .loginProcessingUrl("/authenticate")
                        // ログインページのリクエストURL
                        .loginPage("/login")
                        // 認証成功時のリクエストURL
                        .defaultSuccessUrl("/SignIn")
                        // 認証失敗時のリクエストURL
                        .failureUrl("/loginFailed").permitAll()
                ).logout((logout) -> logout
                        // ログアウト時のリクエストURL
                        .logoutSuccessUrl("/login?logout=true").permitAll()

            ).authorizeHttpRequests((authz) -> authz
                        //新規登録・CSSの認可
                        .requestMatchers("/login/account/**","/css/**").permitAll()
                        //その他のリクエスト
                        .anyRequest().authenticated()
     );
        return http.build();
    }

    // @Beanをつけることで、このメソッドがSpringのコンテナにBeanとして登録される
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

