package cn.hiber.core.web;

/**
 * @author hiber
 */
public class Response {

    private boolean success;

    private String code;

    private String msg;

    private Object data;

    public Response(boolean success, String code, String msg, Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
