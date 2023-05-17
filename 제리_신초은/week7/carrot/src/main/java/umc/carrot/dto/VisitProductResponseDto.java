package umc.carrot.dto;

import lombok.Builder;
import lombok.Data;
import umc.carrot.domain.User;

@Data
public class VisitProductResponseDto {

    //물건 조회수 증가 후 응답 dto
    private String title;

    private User user;

    private int hit;

    @Builder
    public VisitProductResponseDto(String title, User user, int hit) {
        this.title = title;
        this.user = user;
        this.hit = hit;
    }
}
