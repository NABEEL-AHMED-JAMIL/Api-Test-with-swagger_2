package com.example.demo.config;

import com.example.demo.security.TokenHelper;
import com.example.demo.security.auth.LogoutSuccess;
import com.example.demo.security.auth.RestAuthenticationEntryPoint;
import com.example.demo.security.auth.TokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.example.demo.util.RequestMapping.AUTH;
import static com.example.demo.util.RequestMapping.LOGIN;
import static com.example.demo.util.RequestMapping.LOGOUT;

/**
 * @author  by Nabeel on 9/24/2017.
 */
/**************************************************************************
 * @class SecurityConfigurer @extends {@link WebSecurityConfigurerAdapter } that help to perform operation api's class for security
 *
 * @variable TOKEN_COOKIE : {@link String}
 * @variable userDetailsService : {@link UserDetailsService}
 * @variable restAuthenticationEntryPoint : {@link RestAuthenticationEntryPoint}
 * @variable logoutSuccess : {@link LogoutSuccess}
 * @variable tokenHelper : {@link TokenHelper}
 *
 * @Bean passwordEncoder() : PasswordEncoder
 *
 * @method configureGlobal(AuthenticationManagerBuilder auth) : void @throws {@link Exception}
 * @method configure(HttpSecurity http) : void @throws {@link Exception }
 * @method configure(WebSecurity http) : void @throws {@link Exception }
 * @variable SPACE that help the {@link @method isPalindrome({@link String message}) }
 *
 **************************************************************************/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private LogoutSuccess logoutSuccess;

    @Autowired
    TokenHelper tokenHelper;


    /*******************************************************************************
     * A property group for {@link SecurityConfigurer }
     * @method passwordEncoder() : PasswordEncoder
     *
     * @return {@link PasswordEncoder }
     *
     *******************************************************************************/
    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }


    /*****************************************************
     * A property group for {@link SecurityConfigurer }
     * @method configureGlobal() : void @throws {@link Exception}
     *
     * @param auth
     *
     ****************************************************/
    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception {
        auth.userDetailsService( userDetailsService )
                .passwordEncoder( passwordEncoder() );
    }


    /************************************************************************************************
     * A property group for {@link SecurityConfigurer }
     * @method configureGlobal(HttpSecurity http) : void @throws {@link Exception}
     *
     * @param http
     *
     *************************************************************************************************/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS ).and()
                .exceptionHandling().authenticationEntryPoint( restAuthenticationEntryPoint ).and()
                .authorizeRequests().antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated().and()
                .addFilterBefore(new TokenAuthenticationFilter(tokenHelper, userDetailsService),
                        BasicAuthenticationFilter.class)
                .logout().logoutRequestMatcher(new AntPathRequestMatcher(AUTH+LOGOUT))
                .logoutSuccessHandler(logoutSuccess).deleteCookies(TOKEN_COOKIE);
        // disable csrf for the login request
        http.csrf().ignoringAntMatchers(AUTH+LOGIN).
                csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }


    /************************************************************************
     * A property group for {@link SecurityConfigurer }
     * @method configureGlobal(WebSecurity web) : void @throws {@link Exception}
     *
     * @param web
     *
     *
     *************************************************************************/
    @Override
    public void configure(WebSecurity web) throws Exception {
        // TokenAuthenticationFilter will ignore the below paths
        web.ignoring().antMatchers(HttpMethod.POST, AUTH+LOGIN);
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui",
                "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**");
    }

}