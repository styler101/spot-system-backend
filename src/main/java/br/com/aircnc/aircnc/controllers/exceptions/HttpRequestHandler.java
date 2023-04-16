package br.com.aircnc.aircnc.controllers.exceptions;

import br.com.aircnc.aircnc.services.exceptions.InvalidParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class HttpRequestHandler {

    @ExceptionHandler(InvalidParam.class)
    public ResponseEntity<StandardError> userAlreadyExists(InvalidParam exception, HttpServletRequest request){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError();
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        error.setStatus(badRequest.value());
        error.setError("Resource Already exists");
        error.setTimestamp(Instant.now());
        return ResponseEntity.status(badRequest).body(error);

    }
}
