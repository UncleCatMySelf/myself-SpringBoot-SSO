package com.myself.sso2.handler;

import com.myself.sso2.exception.SsoAuthoriException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 13:08 2018\9\16 0016
 */
@ControllerAdvice
public class SsoExceptionHandler {

    /**
     * 拦截登录异常
     * @return
     */
    @ExceptionHandler(value = SsoAuthoriException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("/user/login");
    }


}
