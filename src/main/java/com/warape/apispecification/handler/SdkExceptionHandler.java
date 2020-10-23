package com.warape.apispecification.handler;

import com.warape.apispecification.response.SdkResult;

/**
 * @author wanmingyu
 * @create 2020/10/22 11:46 上午
 */
public class SdkExceptionHandler extends BaseExceptionHandler<SdkResult<?>> {

  @Override
  protected SdkResult<?> getResult (Integer code, String message) {
    return new SdkResult<>(code, message);
  }


}
