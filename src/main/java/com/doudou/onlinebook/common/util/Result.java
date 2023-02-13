package com.doudou.onlinebook.common.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回编码
     */
    private Integer code;

    /**
     * 编码描述
     */
    private String msg;

    /**
     * 业务数据
     */
    private T data;

    private Integer pageTotal;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    /**
     * 返回成功结果对象
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(data);
        return result;
    }
    /**
     * 返回成功结果对象列表
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> successList(T data,Integer total) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(data);
        result.setPageTotal(total);
        return result;
    }
    /**
     * 返回失败结果对象
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String msg) {
        Result result = new Result();
        result.setCode(-9999);
        result.setMsg(msg);
        return result;
    }
}

