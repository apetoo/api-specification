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
public class PageResult<T>  implements Serializable {

  private static final long serialVersionUID = -1;
  private Integer code;
  private String msg;
  private T data;

  public PageResult (Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public PageResult (Integer code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }
}
