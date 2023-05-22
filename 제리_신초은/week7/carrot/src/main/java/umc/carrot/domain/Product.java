package umc.carrot.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Product extends Timestamped{

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @Embedded
    private Location location;

    private int hits;

    private String title;

    private String content;

    private String photo;

    private int price;

    @OneToMany(mappedBy = "product")
    private List<Bookmark> bookmarks = new ArrayList<>();

    private Boolean isSold;

    @Builder
    public Product(User user, Location location, String title, String content, String photo, int price, List<Bookmark> bookmarks) {
        this.user = user;
        this.location = location;
        this.hits = 0;
        this.title = title;
        this.content = content;
        this.photo = photo;
        this.price = price;
        this.bookmarks = bookmarks;
        this.isSold = false;
    }

    /**
     * 물건 조회수 증가
     */
    public void addHits() {
        this.hits = this.hits + 1;
    }
}
