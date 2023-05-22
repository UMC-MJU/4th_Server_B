package umc.boardcrud.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter //Get, Set 함수 한번에 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED)  //기본 생성자 생성, protect level로 생성자 만들어진다. 없으면 public
@Entity             //DB 테이블 역할
public class Board extends Timestamped{
    //게시물 고유 아이디
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Identity로 하는 이유 : 알아서 식별한다음에 아이디를 더해준다. AUTO와 비교 검색해보기
    @Id
    private Long id;

    //게시물 제목
    @Column(nullable = false)
    private String title;

    //게시물 내용
    @Column(nullable = false)
    private String content;

    //비밀번호
    @Column(nullable = false)
    private String password;

    //requestDto 정보를 가져와서 entity 만들 때 사용
    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }

    //업데이트 메소드
    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }
}
