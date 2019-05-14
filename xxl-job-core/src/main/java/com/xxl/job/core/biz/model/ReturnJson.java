package com.xxl.job.core.biz.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回值采用JSON格式
 *
 * @author liuhy
 * @create 2019-05-14 18:19
 **/
public class ReturnJson<T>  implements Serializable {

    public static final long serialVersionUID = 42L;

    public static final String SUCCESS_CODE = "200";
    public static final String FAIL_CODE = "500";




    public static final Map<String,String> params = new HashMap<>();
    private String code;
    private String msg;
    private T content;

    public ReturnJson(){}

    public ReturnJson(String code, String msg, T content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getContent() {
        return content;
    }
    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "{" +
                "'code':" + code +
                ", 'msg':'" + msg + '\'' +
                ", 'content':'" + content +
                "'}";
    }



}
