package com.warape.apispecification.response;

import java.io.Serializable;

import com.warape.apispecification.constant.CommonConstants.ResponseEnum;
import com.warape.apispecification.constant.CommonStatusConstants;

/**
 * 统一响应
 *
 * @author: 万明宇 (warApe)
 **/
public class ApiResult<T> extends BaseResult implements Serializable {

  private static final long serialVersionUID = -1;

  private Integer code;
  private String message;
  private T data;

  public Integer getCode () {
    return code;
  }

  public void setCode (Integer code) {
    this.code = code;
  }

  public String getMessage () {
    return message;
  }

  public void setMessage (String message) {
    this.message = message;
  }

  public T getData () {
    return data;
  }

  public void setData (T data) {
    this.data = data;
  }

  public ApiResult () {
  }

  public ApiResult (Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public ApiResult (Integer code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public static <T> ApiResult.ApiResultBuilder<T> builder () {
    return new ApiResult.ApiResultBuilder<>();
  }


  public static class ApiResultBuilder<T> {

    private Integer code;
    private String message;
    private T data;

    public ApiResultBuilder () {
    }


    public ApiResult.ApiResultBuilder<T> code (Integer code) {
      this.code = code;
      return this;
    }

    public ApiResult.ApiResultBuilder<T> message (String message) {
      this.message = message;
      return this;
    }

    public ApiResult.ApiResultBuilder<T> data (T data) {
      this.data = data;
      return this;
    }

    public ApiResult.ApiResultBuilder<T> success (T data) {
      this.code = ResponseEnum.SUCCESS.getCode();
      this.message = ResponseEnum.SUCCESS.getMessage();
      this.data = data;
      return this;
    }

    public ApiResult.ApiResultBuilder<T> error () {
      this.code = ResponseEnum.ERROR.getCode();
      this.message = ResponseEnum.ERROR.getMessage();
      return this;
    }

    public ApiResult.ApiResultBuilder<T> fail (CommonStatusConstants<Integer> commonStatusConstants) {
      this.code = commonStatusConstants.getCode();
      this.message = commonStatusConstants.getMessage();
      return this;
    }

    public ApiResult.ApiResultBuilder<T> fail (CommonStatusConstants<Integer> commonStatusConstants, T data) {
      this.code = commonStatusConstants.getCode();
      this.message = commonStatusConstants.getMessage();
      this.data = data;
      return this;
    }

    public ApiResult<T> build () {
      return new ApiResult(this.code, this.message, this.data);
    }
  }

}
