package com.warape.apispecification.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wanmingyu
 * @create 2020/10/20 6:15 下午
 */
public interface CommonConstants {

  /**
   * 通用异常
   */
  @Getter
  @AllArgsConstructor
  enum ResponseEnum implements CommonStatusConstants<Integer> {

    /**
     * 成功
     */
    SUCCESS(200,"成功"),
    /**
     * 异常
     */
    ERROR(500,"失败"),
    /**
     * 参数异常
     */
    ILLEGAL_ARGUMENT(100,"参数非法"),
    ;

    private final Integer code;
    private final String message;
  }

  /**
   * 安全认证相关的错误码
   */
  @Getter
  @AllArgsConstructor
  enum SecurityResponseEnum implements CommonStatusConstants<Integer> {
    /**
     * 安全认证相关的错误码
     */
    UNKNOWN_CALLER(10012,"非法请求，未知的调用方"),
    REQUEST_EXPIRED(10013,"非法请求，请求过期"),
    VERIFY_SIGN(10014,"非法请求，签名sign验证失败"),
    EXIST_TOKEN(10021,"非法请求，缺少Token"),
    ERROR_TOKEN(10022,"非法请求，错误的Token"),
    ;

    private final Integer code;
    private final String message;
  }

}
