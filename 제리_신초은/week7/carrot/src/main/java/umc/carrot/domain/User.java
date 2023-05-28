package umc.carrot.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="account_id")
    private Account account;

    @Embedded //내장타입을 포함했다는 어노테이션, Embedded나 Embeddable 둘 중 하나만 써도 되지만, 가독성을 위해 둘 다 써줌
    private Location location;

    @OneToMany(mappedBy = "user")
    private List<Bookmark> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Product> products = new ArrayList<>();

    private String nickname;

    private String email;

    private String phone_number;

    private String profile_image;

    private Float temperature;

    private Float response_rate;

    @Builder
    public User(Account account, Location location, List<Bookmark> bookmarks, List<Product> products, String nickname, String email, String phone_number, String profile_image) {
        this.account = account;
        this.location = location;
        this.bookmarks = bookmarks;
        this.products = products;
        this.nickname = nickname;
        this.email = email;
        this.phone_number = phone_number;
        this.profile_image = profile_image;
        this.temperature = 36.5F;
        this.response_rate = 0F;
    }
}
