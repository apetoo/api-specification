package com.warape.apispecification.response;

import java.io.Serializable;

import com.warape.apispecification.constant.CommonConstants.ResponseEnum;
import com.warape.apispecification.constant.CommonStatusConstants;
import lombok.Builder;
import lombok.Data;

/**
 * 统一响应
 *
 * @author: 万明宇 (warApe)
 **/
@Data
@Builder
public class SdkResult<T> extends BsaeResult implements Serializable {
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

  public SdkResult () {
  }

  public SdkResult (Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public SdkResult (Integer code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public static <T> SdkResult.SdkResultBuilder<T> builder () {
    return new SdkResult.SdkResultBuilder<>();
  }


  public static class SdkResultBuilder<T> {

    private Integer code;
    private String message;
    private T data;

    public SdkResultBuilder () {
    }


    public SdkResult.SdkResultBuilder<T> code (Integer code) {
      this.code = code;
      return this;
    }

    public SdkResult.SdkResultBuilder<T> message (String message) {
      this.message = message;
      return this;
    }

    public SdkResult.SdkResultBuilder<T> data (T data) {
      this.data = data;
      return this;
    }

    public SdkResult.SdkResultBuilder<T> success (T data) {
      this.code = ResponseEnum.SUCCESS.getCode();
      this.message = ResponseEnum.SUCCESS.getMessage();
      this.data = data;
      return this;
    }

    public SdkResult.SdkResultBuilder<T> error () {
      this.code = ResponseEnum.ERROR.getCode();
      this.message = ResponseEnum.ERROR.getMessage();
      return this;
    }

    public SdkResult.SdkResultBuilder<T> fail (CommonStatusConstants<Integer> commonStatusConstants) {
      this.code = commonStatusConstants.getCode();
      this.message = commonStatusConstants.getMessage();
      return this;
    }

    public SdkResult.SdkResultBuilder<T> fail (CommonStatusConstants<Integer> commonStatusConstants, T data) {
      this.code = commonStatusConstants.getCode();
      this.message = commonStatusConstants.getMessage();
      this.data = data;
      return this;
    }

    public SdkResult<T> build () {
      return new SdkResult(this.code, this.message, this.data);
    }
  }
}
