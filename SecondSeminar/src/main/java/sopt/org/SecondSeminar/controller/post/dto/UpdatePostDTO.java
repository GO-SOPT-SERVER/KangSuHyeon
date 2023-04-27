package sopt.org.SecondSeminar.controller.post.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdatePostDTO {
    private String writer;
    private String title;
    private String content;
}
