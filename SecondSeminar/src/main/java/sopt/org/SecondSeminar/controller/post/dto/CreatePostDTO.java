package sopt.org.SecondSeminar.controller.post.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreatePostDTO {
    private String writer;
    private String title;
    private String content;
    private int like;
}
