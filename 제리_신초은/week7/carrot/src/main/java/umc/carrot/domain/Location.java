package umc.carrot.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable     //어딘가에 내장될 수 있다는 의미, 코드를 보기 좋게 하려고 사용
@Getter
//JPA 스펙상 엔티티나 임베디드 타입은 자바 기본 생성자를 public이나 protected로 설정해야 한다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Location {

    private String location_name;

    @Builder
    public Location(String location_name) {
        this.location_name = location_name;
    }


}
