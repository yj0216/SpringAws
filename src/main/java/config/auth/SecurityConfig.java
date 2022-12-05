package config.auth;

import com.example.springaws.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity//Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()//h2-console 화면 사용을 위해 해당 옵션들을 멈춤
                .and()
                .authorizeRequests()//URL 별 권한 관리 설정 시작점
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()//권한 관리 대상 지정(permitAll() 옵션을 통해 전체 열람 권한을 줌)
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())//USER 권환을 가진 사람만 가능(authenticated()를 통해 로그인된 사용자만 허용하도록함)
                .anyRequest().authenticated()//설정 값 이외에 나머지 URL 값들
                .and()
                .logout()//logout 기능 설정
                .logoutSuccessUrl("/")//logout 시 첫 화면으로
                .and()
                .oauth2Login()//login 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint()//login 성공 이후 사용자 정보를 가져올 때 설정 담당
                .userService(customOAuth2UserService);//login 성공시 후속 조치
    }
}
