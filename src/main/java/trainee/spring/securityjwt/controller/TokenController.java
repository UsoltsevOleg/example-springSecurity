package trainee.spring.securityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import trainee.spring.securityjwt.jwt.JwtProvider;

@RestController
public class TokenController {

    @Autowired
    private JwtProvider jwtProvider;

    @RequestMapping(value = "/update/token", method = RequestMethod.POST)
    public ResponseEntity<String> createToken(@RequestHeader String token, Authentication authResult) {
        String access_token = jwtProvider.createToken(authResult);
        String refresh_token = jwtProvider.createRefreshToken(authResult);
        return new ResponseEntity<String>(refresh_token, HttpStatus.UPGRADE_REQUIRED);
    }
}
