package sopt.org.fourthSeminar.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sopt.org.fourthSeminar.common.dto.ApiResponse;
import sopt.org.fourthSeminar.config.resolver.UserId;
import sopt.org.fourthSeminar.controller.request.dto.BoardImageListRequestDto;
import sopt.org.fourthSeminar.controller.request.dto.BoardRequestDto;
import sopt.org.fourthSeminar.exception.Success;
import sopt.org.fourthSeminar.external.client.aws.S3Service;
import sopt.org.fourthSeminar.service.BoardService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@SecurityRequirement(name = "JWT Auth")
public class BoardController {

    private final BoardService boardService;
    private final S3Service s3Service;

    @PostMapping(value = "/create/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    //ModelAttri -> 적합한 생성자 만들어줌? -> 데이터 바인딩이 setter를 하지 않으면 -> allArgs
    public ApiResponse create(@UserId Long userId, @ModelAttribute @Valid final BoardRequestDto request) {
        String boardThumbnailImageUrl = s3Service.uploadImage(request.getThumbnail(), "board");
        boardService.create(userId, boardThumbnailImageUrl, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }

    @PostMapping(value = "/create/images/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    //ModelAttri -> List는 데이터바인딩 안됨..
    public ApiResponse create(@UserId Long userId, @ModelAttribute @Valid final BoardImageListRequestDto request) {
        List<String> boardThumbnailImageUrlList = s3Service.uploadsImages(request.getBoardImages(), "board");
        boardService.create(userId, boardThumbnailImageUrlList, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}
