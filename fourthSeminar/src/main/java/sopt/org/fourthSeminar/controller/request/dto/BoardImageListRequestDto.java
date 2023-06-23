package sopt.org.fourthSeminar.controller.request.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardImageListRequestDto {
    private List<MultipartFile> boardImages;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private Boolean isPublic;

//    public void setBoardImages(List<MultipartFile> boardImages) {
//        this.boardImages = boardImages;
//    }


}
