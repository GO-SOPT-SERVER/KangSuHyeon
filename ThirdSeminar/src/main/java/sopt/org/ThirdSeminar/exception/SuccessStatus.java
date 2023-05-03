package sopt.org.ThirdSeminar.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {
    /*
    user
    */
    SIGNUP_SUCCESS(HttpStatus.CREATED, "유저 생성 성공"),

    /*
    post
     */
    CREATE_POST_SUCCESS(HttpStatus.CREATED, "게시물 작성 성공"),
    READ_ALL_POST(HttpStatus.OK, "게시물 조회 성공"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
