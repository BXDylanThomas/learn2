package com.dylan.xinyidai05.interfaces.common.result;

/**
 * @author baoxiang
 * @create 2020-06-28 10:55
 */
public class ResultData<T> {

    private ResultData(){}

    private int code;
    private String message;
    private T data;

    public static <T> ResultData<T> builder(ResultConstant resultConstant,T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(resultConstant.getCode());
        resultData.setMessage(resultConstant.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
 