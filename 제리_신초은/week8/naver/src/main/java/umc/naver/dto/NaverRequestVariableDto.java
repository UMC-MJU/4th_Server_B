package umc.naver.dto;

import lombok.Data;

@Data
//Naver API 요청
public class NaverRequestVariableDto {

    String query;
    Integer display;
    Integer start;
    String sort;

}