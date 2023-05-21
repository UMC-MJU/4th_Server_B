package umc.carrot.dto;

import lombok.Data;

@Data
public class ProductRequestDto {

    //요청
    private String title;

    private String content;

    private String photo;

    private int price;

    private String location;

    private Long user_id;

}
