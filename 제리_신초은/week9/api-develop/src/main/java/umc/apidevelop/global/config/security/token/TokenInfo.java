package umc.apidevelop.global.config.security.token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
// 클라이언트에 토큰을 보내기 위한 DTO
public class TokenInfo {

    private String grantType;
    private String accessToken;
    private String refreshToken;

}
