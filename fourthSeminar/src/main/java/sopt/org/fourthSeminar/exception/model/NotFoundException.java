package sopt.org.fourthSeminar.exception.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import sopt.org.fourthSeminar.exception.Error;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends SoptException{

    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}
