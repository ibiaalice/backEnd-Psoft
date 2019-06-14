package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class UserExistException extends RuntimeException {
	public UserExistException(String msg) {
	       super(msg);
	}

}
