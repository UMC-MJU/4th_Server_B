package com.umcblog.Blog.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@Getter
@Setter
public class MemberDto {
    private String user_id;
    private String password;



}
