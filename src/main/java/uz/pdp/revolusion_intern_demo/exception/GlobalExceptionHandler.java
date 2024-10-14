package uz.pdp.revolusion_intern_demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.revolusion_intern_demo.payload.ApiResult;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RestException.class)
    public ApiResult<?> restExceptionHandler(RestException restException) {
        return ApiResult.error(restException.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ApiResult<?> runtimeExceptionHandler(RuntimeException runtimeException) {
        return ApiResult.error(runtimeException.getMessage());
    }


}
