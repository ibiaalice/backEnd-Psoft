package exception;

import java.sql.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

   @ExceptionHandler(Exception.class)
   public ResponseEntity<CustomRestError> handleAnyException(Exception ex, WebRequest request) {
       CustomRestError errorMessage = new CustomRestError();
       return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
   }

   @ExceptionHandler({UserNotExistException.class, })
   public ResponseEntity<CustomRestError> notFound(Exception ex, WebRequest request) {
       CustomRestError errorMessage = new CustomRestError();
       return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
   }
   
   public ResponseEntity<CustomRestError> alreadyExist(Exception ex, WebRequest request){
	   CustomRestError errorMessage = new CustomRestError();
	   return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.ALREADY_REPORTED);
   }
}
