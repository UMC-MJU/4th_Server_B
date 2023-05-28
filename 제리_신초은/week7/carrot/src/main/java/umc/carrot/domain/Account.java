package umc.carrot.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long account_id;

    @OneToOne(mappedBy = "account")
    private User user;

    private int balance;

    private String password;

    private String bank_name;

    private String account_number;

    //JPA 스펙상 엔티티나 임베디드 타입은 자바 기본 생성자를 public이나 protected로 설정해야 한다.
    protected Account() {
    }

    //생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만들자
    @Builder
    public Account(User user, int balance, String password, String bank_name, String account_number) {
        this.user = user;
        this.balance = balance;
        this.password = password;
        this.bank_name = bank_name;
        this.account_number = account_number;
    }

}
