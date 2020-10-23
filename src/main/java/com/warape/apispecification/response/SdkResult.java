package com.warape.apispecification.response;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * 统一响应
 *
 * @author: 万明宇 (warApe)
 **/
@Data
@Builder
public class SdkResult<T> implements Serializable {
  private Integer code;
  private String message;
  private T data;

  public SdkResult (Integer code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public SdkResult (Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}
