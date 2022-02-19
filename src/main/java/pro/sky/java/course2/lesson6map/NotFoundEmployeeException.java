package pro.sky.java.course2.lesson6map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundEmployeeException extends RuntimeException {
}
