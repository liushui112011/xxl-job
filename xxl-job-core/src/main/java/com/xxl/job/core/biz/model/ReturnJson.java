package com.xxl.job.core.biz.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * 返回值采用JSON格式
 *
 * @author liuhy
 * @create 2019-05-14 18:19
 **/
public class ReturnJson  implements Serializable {

    public static final long serialVersionUID = 42L;

    public static final String SUCCESS_CODE = "200";
    public static final String FAIL_CODE = "500";

    public static final ReturnJson SUCCESS = new ReturnJson(null);
    public static final ReturnJson FAIL = new ReturnJson(FAIL_CODE, null);

    public static final JSONObject jsonObject = new JSONObject(new LinkedHashMap<String, Object>());

    private String code;
    private String msg;

    public ReturnJson(){}


    public ReturnJson(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ReturnJson(String msg) {
        this.code = SUCCESS_CODE;
        this.msg = msg;
    }

    public JSONObject toJson(){
        this.jsonObject.put("code",this.code);
        this.jsonObject.put("msg",this.msg);
        return jsonObject;
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


    @Override
    public String toString() {
        return "ReturnJson{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
