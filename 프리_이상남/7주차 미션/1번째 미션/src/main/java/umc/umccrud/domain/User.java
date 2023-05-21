package umc.umccrud.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String subject;

    public User(String subject) {
        this.subject = subject;
    }

    public User() {

    }
}
