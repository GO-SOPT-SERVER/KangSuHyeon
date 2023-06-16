package sopt.org.fourthSeminar.config.resolver;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import sopt.org.fourthSeminar.config.jwt.JwtService;
import sopt.org.fourthSeminar.exception.Error;
import sopt.org.fourthSeminar.exception.model.UnauthorizedException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Component //타입기반의 자동주입 어노테이션 -> 등록된 Bean 객체 가져옴

//HandlerMethodArgumentResolver: 주어진 요청을 처리할 때, 메소드 파라미터를 인자값들에 주입 해주는 전략 인터페이스
public class UserIdResolver implements HandlerMethodArgumentResolver {

    private final JwtService jwtService;

    //핸들러(컨트롤러 메소드)의 특정 파라미터를 지원하는지 여부를 판단하기 위한 메소드
    //어떤 파라미터에 대한 작업을 수행할 것인지 지정
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(UserId.class) && Long.class.equals(parameter.getParameterType());
    }

    //파라미터에 대한 로직 수행
    @Override
    public Object resolveArgument(@NotNull MethodParameter parameter, ModelAndViewContainer mavContainer, @NotNull NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        final HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        final String token = request.getHeader("Authorization");

        //토큰 검증
        if (!jwtService.verifyToken(token)) {
            throw new UnauthorizedException(Error.UNAUTHORIZED_TOKEN_EXCEPTION, Error.UNAUTHORIZED_TOKEN_EXCEPTION.getMessage());
        }

        //유저 아이디 반환
        final String tokenContents = jwtService.getJwtContents(token);
        try {
            return Long.parseLong(tokenContents);
        } catch (NumberFormatException e) {
            throw new RuntimeException(String.format("USER_ID를 가져오지 못했습니다. (%s - %s)", parameter.getClass(), parameter.getMethod()));
        }
    }
}
