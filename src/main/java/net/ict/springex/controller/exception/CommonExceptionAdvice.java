package net.ict.springex.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice //예외처리 어노테이션
@Log4j2
public class CommonExceptionAdvice {

//    @ResponseBody //만들어진 문자열을 그대로 브라우저에 전달하겠다 -> "NUMBER FORMAT EXCEPTION" 바디에 RESPONSE하겠다
//    @ExceptionHandler(NumberFormatException.class) //익셉션 핸들러 지정
    //숫자가 들어오지 않으면 except발생
//    public String exceptNumber(NumberFormatException numberFormatException){
//        log.error("===========");  //log.error : 에러처리 출력
//        log.error(numberFormatException.getMessage());
//        return "NUMBER FORMAT EXCEPTION";
//    }
    //예외 처리의 최상위 타입인 Exception타입을 처리하도록 구성 exceptionCommon(Exception exception)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptNumber(Exception exception){
        log.error("===========");  //log.error : 에러처리 출력
        log.error(exception.getMessage());
        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>"+exception.getMessage()+"</li>");
        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>"+stackTraceElement+"</li>");
        });
        buffer.append("</ul>");

        return buffer.toString();
    }
    @ExceptionHandler(NoHandlerFoundException.class) //내가 원하는 핸들링 페이지 없을 때
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        return "custom404";
    }
}
