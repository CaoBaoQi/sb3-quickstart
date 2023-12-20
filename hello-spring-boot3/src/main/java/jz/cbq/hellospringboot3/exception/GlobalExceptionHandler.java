package jz.cbq.hellospringboot3.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler
 *
 * @author caobaoqi
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e){
            if (e instanceof ArithmeticException){
                if (log.isDebugEnabled()){
                    log.debug(e.getMessage());
                }
                return "数据异常";
            }
        return "服务器内部异常";
    }
}
