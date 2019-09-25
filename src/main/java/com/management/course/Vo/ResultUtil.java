package com.management.course.Vo;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/10 20:49
 */
public class ResultUtil<T> {
    private Result<T> result;
    public ResultUtil(){
        result = new Result<>();
        result.setSuccess(true);
        result.setMessage("success");
        result.setCode(200);
    }
    public Result<T> setData(T t){
        this.result.setResult(t);
        this.result.setCode(200);
        return this.result;
    }

    public Result<T> setSuccessMsg(String msg){
        this.result.setMessage(msg);
        this.result.setSuccess(true);
        this.result.setCode(200);
        this.result.setResult(null);
        return this.result;
    }
    public Result<T> setErrorMsg(String msg){
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(500);
        return this.result;
    }

    public Result<T> setErrorMsg(Integer code, String msg){
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(code);
        return this.result;
    }
}
