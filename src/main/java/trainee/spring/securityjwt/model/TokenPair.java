package trainee.spring.securityjwt.model;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
public class TokenPair {

    private String accessToken;
    private String refreshToken;
}
