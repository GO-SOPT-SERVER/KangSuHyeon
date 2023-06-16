package sopt.org.fourthSeminar.common.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sopt.org.fourthSeminar.common.dto.ApiResponse;
import sopt.org.fourthSeminar.exception.Error;
import sopt.org.fourthSeminar.exception.model.BadRequestException;
import sopt.org.fourthSeminar.exception.model.SoptException;

import java.util.Objects;

@RestControllerAdvice
//
public class ControllerExceptionAdvice {
    /**
     * Spring 예외 처리 과정
     * [1] <ExceptionHandlerExceptionResolver> 동작
     *   1. 예외가 발생한 컨트롤러 내부에 적합한 @ExceptionHandler가 있는 지 확인 후 처리
     *   2. 없으면, ControllerAdvice로 넘어감
     *   3. ControllerAdvice안에 적합한 @ExceptionHandler가 있으면 처리 후 없으면 다음 Resolver로 넘어감
     * [2] <ResponseStatusExceptionResolver>가 동작함
     *   1. @ResponseStatus가 있는지 또는 ResponseStatusException인지 검사함
     *   2. 맞으면 ServletResponse의 sendError()로 예외를 서블릿까지 전달되고, 서블릿이 BasicErrorController로 요청을 전달함
     * [3] <DefaultHandlerExceptionResolver>가 동작함 - 스프링 내부 기본 예외 처리
     *   - Spring의 내부 예외인지 검사하여 맞으면 에러를 처리하고 아니면 넘어감
     * [4] 적합한 ExceptionResolver가 없으므로 예외가 서블릿까지 전달되고, 서블릿은 SpringBoot가 진행한 자동 설정에 맞게 BasicErrorController로 요청을 다시 전달함

     !!가장 구체적인 예외 핸들러를 먼저 찾고 -> 없으면 부모 예외의 핸들러를 찾는다.

     500에러는 주석 처리하고 최대한 많은 에러를 발생시켜보면서 꼼꼼하게 처리하기
     */
    /**
     * 400 BAD_REQUEST
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        FieldError fieldError = Objects.requireNonNull(e.getFieldError());
        return ApiResponse.error(Error.REQUEST_VALIDATION_EXCEPTION, String.format("%s. (%s)", fieldError.getDefaultMessage(), fieldError.getField()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    protected ApiResponse handleBadRequestException(final BadRequestException e) {
        return ApiResponse.error(e.getError(), e.getMessage());
    }

    /**
     * 500 Internal Server
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    protected ApiResponse<Object> handleException(final Exception e) {
        return ApiResponse.error(Error.INTERNAL_SERVER_ERROR);
    }

    /**
     * Sopt custom error
     */
    @ExceptionHandler(SoptException.class)
    protected ResponseEntity<ApiResponse> handleSoptException(SoptException e) {
        return ResponseEntity.status(e.getHttpStatus())
                .body(ApiResponse.error(e.getError(), e.getMessage()));
    }
}
