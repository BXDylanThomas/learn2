package com.dylan.xinyidai05.interfaces.common;

import com.dylan.xinyidai05.interfaces.common.result.Error;
import com.dylan.xinyidai05.interfaces.common.result.ResultConstant;
import com.dylan.xinyidai05.interfaces.common.result.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author baoxiang
 * @create 2020-06-28 11:09
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandle {
    public GlobalExceptionHandle() {}

    @ExceptionHandler(NullPointerException.class)
    public ResultData<Error> nullException(Exception e){
        log.info("异常：{}",e);
        Error error = Error.builder().no(1).message("空指针").build();
        return ResultData.builder(ResultConstant.FAIL,error);
    }
}
 