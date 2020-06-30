package com.dylan.xinyidai05.interfaces.common.result;

/**
 * @author baoxiang
 * @create 2020-06-28 10:57
 */
public class ResultConstant {
    public final static ResultConstant SUCCESS = new ResultConstant(200,"请求成功");
    public final static ResultConstant FAIL = new ResultConstant(500,"处理异常");

    private int code;
    private String message;

    public ResultConstant(int code, String message) {
        this.code = code;
        this.message = message;
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
}
 