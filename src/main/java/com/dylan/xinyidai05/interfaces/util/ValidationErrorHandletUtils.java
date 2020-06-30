package com.dylan.xinyidai05.interfaces.util;

import com.dylan.xinyidai05.interfaces.common.result.Error;
import com.dylan.xinyidai05.interfaces.common.result.ResultConstant;
import com.dylan.xinyidai05.interfaces.common.result.ResultData;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * 统一处理<code>@valid</code>校验的错误信息
 *
 * @author baoxiang
 * @create 2020-06-28 10:51
 */
public class ValidationErrorHandletUtils {

    public static ResultData<List<Error>> errorDeal(BindingResult bindingResult){
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        List<Error> errorList = new ArrayList<>();
        for (int i = 0; i < allErrors.size(); i++) {
            ObjectError error = allErrors.get(i);
            errorList.add(Error.builder().no(i+1).message(error.getDefaultMessage()).build());
        }
        return ResultData.builder(ResultConstant.FAIL,errorList);
    }
}
 