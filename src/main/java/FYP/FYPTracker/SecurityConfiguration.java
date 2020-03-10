//package FYP.FYPTracker;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	//@Autowired
//	//private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
////	@Autowired
////	private DataSource dataSource;
////
////	@Value("${spring.queries.users-query}")
////	private String usersQuery;
////
////	@Value("${spring.queries.roles-query}")
////	private String rolesQuery;
//
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
////		.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
////	}
//	
//	//@Autowired
//    //private MyUserDetailsService userDetailsService;
//	
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	auth.inMemoryAuthentication()
//        .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
//        .and()
//        .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//        .and()
//        .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//    }
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http
//        .csrf().disable()
//        .authorizeRequests()
//        .antMatchers("/admin/**").hasRole("ADMIN")
//        .antMatchers("/user/**").hasRole("USER")
//        .antMatchers("/login","/").permitAll()
//        .anyRequest().authenticated()
//        .and()
//        .formLogin()
//        .loginPage("/login")
//        .loginProcessingUrl("/perform_login")
//        .defaultSuccessUrl("/homepage.html", true)
//        //.failureUrl("/login.html?error=true")
//        .and()
//        .logout()
//        .logoutUrl("/perform_logout")
//        .deleteCookies("JSESSIONID");
//	}
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//	}
//	
//	@Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//	
//}
