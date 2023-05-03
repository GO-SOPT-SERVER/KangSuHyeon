package sopt.org.ThirdSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.ThirdSeminar.common.dto.ApiResponseDto;
import sopt.org.ThirdSeminar.controller.dto.request.PostRequestDto;
import sopt.org.ThirdSeminar.controller.dto.response.PostResponseDto;
import sopt.org.ThirdSeminar.exception.SuccessStatus;
import sopt.org.ThirdSeminar.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    //게시물 생성
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<PostResponseDto> createPost(@RequestBody final PostRequestDto request) {
        return ApiResponseDto.success(SuccessStatus.CREATE_POST_SUCCESS, postService.createPost(request));
    }

    //유저아이디로 게시물 조회
    @GetMapping("/{userId}")
    public ApiResponseDto<List<PostResponseDto>> getPostByUserId(@PathVariable final int userId) {
        return ApiResponseDto.success(SuccessStatus.READ_ALL_POST, postService.getPostByUserId((long) userId));
    }

    //제목으로 게시물 조회
    @GetMapping("")
    public ApiResponseDto<List<PostResponseDto>> getPostByTitle(@RequestParam final String title) {
        return ApiResponseDto.success(SuccessStatus.READ_ALL_POST, postService.getPostByTitle(title));
    }
}
