package com.atyouxuan.yx.common.exception;

import com.atyouxuan.yx.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//AOP 面向切面
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) //异常处理器
    @ResponseBody  //返回json数据
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail(null);
    }

    //自定义异常处理
    @ExceptionHandler(yxException.class)
    @ResponseBody
    public Result error(yxException exception) {
        return Result.build(null,exception.getCode(),exception.getMessage());
    }
}
