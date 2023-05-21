package umc.carrot.dto;

import lombok.Builder;
import lombok.Data;
import umc.carrot.domain.Location;

import java.time.LocalDateTime;

@Data
public class ProductResponseDto {

    //응답

    private String title;

    private String content;

    private String photo;

    private int price;

    private Location location;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    private Boolean isSold;

    @Builder
    public ProductResponseDto(String title, String content, String photo, int price, Location location, LocalDateTime createdAt, LocalDateTime modifiedAt, Boolean isSold) {
        this.title = title;
        this.content = content;
        this.photo = photo;
        this.price = price;
        this.location = location;
        this.isSold = isSold;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
