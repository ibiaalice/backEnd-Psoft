package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class DisciplineNotExistsException extends RuntimeException {
	public DisciplineNotExistsException(String msg) {
		super(msg);
	}
}
