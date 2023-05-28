package umc.carrot.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;

    private String nickname;

    private String email;

    private String phone_number;

    private String profile_image;

    private Float temperature;

    private Float response_rate;

    @Builder
    public UserResponseDto(Long id, String nickname, String email, String phone_number, String profile_image, Float temperature, Float response_rate) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.phone_number = phone_number;
        this.profile_image = profile_image;
        this.temperature = temperature;
        this.response_rate = response_rate;
    }
}
