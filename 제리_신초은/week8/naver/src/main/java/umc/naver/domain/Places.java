package umc.naver.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Places {

    private String title;

    private String link;

    private String category;

    private String description;

    private String telephone;

    private String address;

    private String roadAddress;

    private String mapx;

    private String mapy;

    @Builder
    public Places(String title, String link, String category, String description, String telephone, String address, String roadAddress, String mapx, String mapy) {
        this.title = title;
        this.link = link;
        this.category = category;
        this.description = description;
        this.telephone = telephone;
        this.address = address;
        this.roadAddress = roadAddress;
        this.mapx = mapx;
        this.mapy = mapy;
    }
}
