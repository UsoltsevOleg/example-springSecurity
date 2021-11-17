package trainee.spring.securityjwt.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import trainee.spring.securityjwt.jwt.JwtProvider;
import trainee.spring.securityjwt.model.TokenPair;

import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
@RestController
public class TokenController {

    @Autowired
    JwtProvider jwtProvider;

    @GetMapping("/update/token")
    public TokenPair updateTokens(Authentication authentication, HttpServletResponse response) {
        TokenPair tokenPair = new TokenPair();
        tokenPair.setAccessToken(jwtProvider.createToken(authentication));
        tokenPair.setRefreshToken(jwtProvider.createRefreshToken(authentication));
        return tokenPair;
    }
}
