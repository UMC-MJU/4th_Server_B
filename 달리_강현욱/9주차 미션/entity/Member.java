package com.umcblog.Blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user_id;
    @JsonIgnore
    private String password;
    private String name;
    private String phone;
    @Builder
    public Member(String user_id, String password, String name, String phone){
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.phone = phone;

    }
}
