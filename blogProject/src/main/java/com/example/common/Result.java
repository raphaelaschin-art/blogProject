package com.example.common;

import lombok.Data;

/**
 * 统一响应结果封装
 *
 * @param <T> 数据类型
 */
@Data
public class Result<T> {

    private Integer code;
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功，无数据
     */
    public static <T> Result<T> success() {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMsg("操作成功");
        return r;
    }

    /**
     * 成功，带数据
     */
    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMsg("操作成功");
        r.setData(data);
        return r; // ✅补上了你缺失的return
    }

    /**
     * 失败，自定义提示，默认code=500
     */
    public static <T> Result<T> error(String msg) {
        Result<T> r = new Result<>();
        r.setCode(500);
        r.setMsg(msg);
        return r;
    }

    /**
     * 【新增】失败：自定义code+自定义消息（方便业务使用）
     */
    public static <T> Result<T> error(Integer code, String msg) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    // getter / setter 一定要保留！不能删掉
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

    /**
     * 查询成功，但是无数据，code=200，data=null
     */
    public static <T> Result<T> noData(String msg) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }

}

