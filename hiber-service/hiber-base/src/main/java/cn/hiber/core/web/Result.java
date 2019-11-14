package cn.hiber.core.web;

import lombok.Data;

/**
 * @author hiber
 */
@Data
public class Result {

    private static final String SUCCESS_CODE = "1";
    private static final String FAIL_CODE = "0";

    private boolean success;

    private String code;

    private String msg;

    private Object data;

    private Result(boolean success, String code, String msg, Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(boolean success, String code, String msg) {
        this(success,code,msg,null);
    }

    public static Result ok() {
        return new Result(true,SUCCESS_CODE,null);
    }

    public static Result ok(String msg) {
        return new Result(true,SUCCESS_CODE,msg);
    }

    public static Result ok(Object data) {
        return new Result(true,SUCCESS_CODE,null,data);
    }

    public static Result ok(String msg, Object data) {
        return new Result(true,SUCCESS_CODE,msg,data);
    }

    public static Result fail() {
        return new Result(false,FAIL_CODE,null);
    }

    public static Result failWithMsg(String msg) {
        return new Result(false, FAIL_CODE ,msg);
    }

    public static Result failWithCode(String code) {
        return new Result(false, code ,null);
    }

    public static Result fail(Object data) {
        return new Result(false,FAIL_CODE,null,data);
    }

    public static Result fail(String code, String msg, Object data) {
        return new Result(false,code,msg,data);
    }


}
