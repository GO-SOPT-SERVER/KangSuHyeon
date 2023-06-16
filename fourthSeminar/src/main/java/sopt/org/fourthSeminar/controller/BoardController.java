package sopt.org.fourthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.fourthSeminar.common.dto.ApiResponse;
import sopt.org.fourthSeminar.config.jwt.JwtService;
import sopt.org.fourthSeminar.config.resolver.UserId;
import sopt.org.fourthSeminar.controller.request.dto.BoardRequestDto;
import sopt.org.fourthSeminar.exception.Success;
import sopt.org.fourthSeminar.service.BoardService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final JwtService jwtService;

//    @PostMapping("/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ApiResponse create(
//            @RequestHeader("Authorization") String accessToken,
//            @RequestBody @Valid final BoardRequestDto request) {
//        boardService.create(Long.parseLong(jwtService.getJwtContents(accessToken)), request);
//        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
//    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId Long userId,
            @RequestBody @Valid final BoardRequestDto request) {
        boardService.create(userId, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }

}
