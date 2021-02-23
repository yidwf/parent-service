package com.yesido.rpc.proto;

/**
 * 
 * @author yesido
 * @param <T>
 * @date 2019年9月11日 下午2:23:30
 */
public class RPCResult<T> {

    /** --成功-- **/
    public final static int CODE_SUCCESS = 0;
    public final static int CODE_SUCCESS_200 = 200;
    /** --熔断降级-- **/
    public final static int CODE_FALLBACK = 1;
    /** --业务错误-- **/
    public final static int CODE_BIZ = 400;
    /** --权限错误 || 拒接访问-- **/
    public final static int CODE_UNAUTHORIZED = 401;
    /** --不存在的资源-- **/
    public final static int CODE_NOT_FOUND = 404;
    /** --系统错误-- **/
    public final static int CODE_SERVER_ERROR = 500;
    /** --参数错误-- **/
    public final static int CODE_PARAMS = 504;

    /** 响应码 **/
    private int code;
    /** 响应提示信息 **/
    private String msg;
    /** 响应数据 **/
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean success() {
        return CODE_SUCCESS == code || CODE_SUCCESS_200 == code;
    }

    public RPCResult(int code) {
        super();
        this.code = code;
    }

    public RPCResult(int code, T data) {
        super();
        this.code = code;
        this.data = data;
    }

    public static <V> RPCResult<V> ok() {
        return new RPCResult<V>(CODE_SUCCESS);
    }

    public static <V> RPCResult<V> ok(V data) {
        return new RPCResult<V>(CODE_SUCCESS, data);
    }

    public static <V> RPCResult<V> fallback() {
        RPCResult<V> r = new RPCResult<V>(CODE_FALLBACK);
        r.setMsg("请求熔断降级，请查看日志");
        return r;
    }

    public static <V> RPCResult<V> fallback(String msg) {
        RPCResult<V> r = new RPCResult<V>(CODE_FALLBACK);
        r.setMsg(msg);
        return r;
    }

    public static <V> RPCResult<V> result(int code, String msg, V data) {
        RPCResult<V> r = new RPCResult<V>(code, data);
        r.setMsg(msg);
        return r;
    }
}
