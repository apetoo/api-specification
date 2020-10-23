package com.warape.apispecification.handler;

import com.warape.apispecification.response.ApiResult;
import org.springframework.stereotype.Component;

/**
 * @author wanmingyu
 * @create 2020/10/22 11:46 上午
 */
@Component
public class ApiExceptionHandler extends BaseExceptionHandler<ApiResult<?>> {

  @Override
  protected ApiResult<?> getResult (Integer code, String message) {
    return new ApiResult<>(code, message);
  }
}
