package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe de exception para o login
 * @author biaalice
 *
 */
@ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
public class AuthException extends RuntimeException {
	public AuthException(String msg) {
	       super(msg);
	}
}
