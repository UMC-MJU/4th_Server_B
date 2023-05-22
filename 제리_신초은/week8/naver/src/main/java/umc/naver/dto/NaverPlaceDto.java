package umc.naver.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NaverPlaceDto {

    private String title;
    private String link;
    private String address;
    private String roadAddress;

    @Builder
    public NaverPlaceDto(String title, String link, String address, String roadAddress) {
        this.title = title;
        this.link = link;
        this.address = address;
        this.roadAddress = roadAddress;
    }
}
