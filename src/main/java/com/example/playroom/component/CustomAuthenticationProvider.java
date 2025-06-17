package com.example.playroom.component;

import com.example.playroom.dto.Account;
import com.example.playroom.form.Login.LoginForm;
import com.example.playroom.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final AuthenticationService authenticationService;
    private final BCryptPasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(AuthenticationService authenticationService, BCryptPasswordEncoder passwordEncoder) {
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    /*
    SecurityConfigに記載されている「.loginProcessingUrl("/authenticate")　」箇所のautenticateメソッドの実態
    ユーザーがユーザーとパスワードを入力するとこのメソッドで認証するか判断
    認証する場合はUsernamePasswordAuthenticationTokenを返却
    認証しない場合はエラーを発生させる。
    */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String accountCode = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        Optional<Account> accountOpt = authenticationService.getAuthInfo(accountCode);

        // ユーザーの存在判定
        // 入力されたアカウントコードが存在しな場合エラー
        if(accountOpt.isEmpty()){
            throw new UsernameNotFoundException("入力されたアカウントコードは存在しませんでした。");
        }
        Account account = accountOpt.get();

        if (passwordEncoder.matches(password, account.getPassword())) {
            return new UsernamePasswordAuthenticationToken(accountCode, password, null);
        } else {
            throw new BadCredentialsException("パスワードが一致しませんでした。");
        }
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}