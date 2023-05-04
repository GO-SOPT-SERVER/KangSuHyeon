package sopt.org.ThirdSeminar.controller.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class PostRequestDto {
    @NotNull
    private Long userId;
    @NotNull
    private String title;
    private String content;

}
