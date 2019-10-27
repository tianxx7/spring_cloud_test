package txx.spring__boot_base1.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/*
 * 统一接口的异常处理
 * */
@ControllerAdvice
public class GlobelExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobelExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData defaultErrorHandler(HttpServletRequest request,Exception e){
        logger.error("",e);
        ResponseData responseData = new ResponseData();
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException){
            responseData.setCode(404);
        } else {
            responseData.setCode(500);
        }
        responseData.setData(null);
        responseData.setStatus(false);
        return responseData;
    }

}
