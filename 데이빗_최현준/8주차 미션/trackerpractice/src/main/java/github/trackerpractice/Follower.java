package github.trackerpractice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Follower {
    private String username;
    private String url;
    private String imageUrl;
}
