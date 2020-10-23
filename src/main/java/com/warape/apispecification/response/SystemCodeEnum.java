package com.warape.apispecification.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统编码枚举
 * @author wanmingyu
 * @create 2020/10/20 6:44 下午
 */
@Getter
@AllArgsConstructor
public enum SystemCodeEnum {

  /**
   * 账户系统
   */
  ACCOUNT("kd1000","账户系统"),
  ;
  private final String code;
  private final String name;
}
