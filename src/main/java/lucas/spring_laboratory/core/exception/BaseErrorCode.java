package lucas.spring_laboratory.core.exception;

import org.springframework.http.HttpStatus;

public interface BaseErrorCode<T extends Exception> {

  String name();

  String getMessage();

  HttpStatus getHttpStatus();

  T toException();
}