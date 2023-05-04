package sopt.org.ThirdSeminar.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto {
    private Long postId;
    private String title;
    private String content;

    public static PostResponseDto of(Long postId, String title, String content) {
        return new PostResponseDto(postId, title, content);
    }
}
