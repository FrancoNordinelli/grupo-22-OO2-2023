package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import services.UserService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/css/*", "/imgs/*", "/js/*", "/vendor/bootstrap/css/*",
                        "/vendor/jquery/*", "/vendor/bootstrap/js/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin(login -> login.loginPage("/login").loginProcessingUrl("/loginprocess")
                        .usernameParameter("username").passwordParameter("password")
                        .defaultSuccessUrl("/loginsuccess").permitAll())
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll());
		return http.build();
	}

//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers(
//                        "/static/favicon.ico", "/resources/**",
//                        "/static/**",
//                        "/css/**",
//                        "/scripts/**",
//                        "/img/**",
//                        "/webjars/",
//                        "/webjars/**")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").loginProcessingUrl("/loginprocess")
//                .usernameParameter("username").passwordParameter("password")
//                .defaultSuccessUrl("/loginsuccess").permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll()
//                .and().exceptionHandling().accessDeniedPage("/error/401");
//    }
	
	
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http
//        .authorizeRequests(authorize -> authorize
//            .antMatchers("/css/*", "/imgs/*", "/js/*", "/vendor/bootstrap/css/*",
//                        "/vendor/jquery/*", "/vendor/bootstrap/js/*").permitAll()
//            .anyRequest().authenticated()
//        )
//        .formLogin(form -> form
//            .loginPage("/login")
//            .loginProcessingUrl("/loginprocess")
//            .usernameParameter("username")
//            .passwordParameter("password")
//            .defaultSuccessUrl("/loginsuccess")
//            .permitAll()
//        )
//        .logout(logout -> logout
//            .logoutUrl("/logout")
//            .logoutSuccessUrl("/logout")
//            .permitAll()
//        );
//    return http.build();
//}

}
