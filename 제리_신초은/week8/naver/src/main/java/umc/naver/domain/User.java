package umc.naver.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {

    private String name;
    private int age;

    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
