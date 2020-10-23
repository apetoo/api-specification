package com.warape.apispecification.handler;

import com.warape.apispecification.response.PageResult;

/**
 * @author wanmingyu
 * @create 2020/10/22 11:46 上午
 */
public class PageExceptionHandler extends BaseExceptionHandler<PageResult<?>> {

  @Override
  protected PageResult<?> getResult (Integer code, String message) {
    return new PageResult<>(code, message);
  }
}
