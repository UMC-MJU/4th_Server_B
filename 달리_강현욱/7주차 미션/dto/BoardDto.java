package com.umcblog.Blog.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@RequiredArgsConstructor
@Getter
@Setter
public class BoardDto {
    private String title;
    private String content;
}
