package com.warape.apispecification.handler;

import java.util.stream.Collectors;

import com.warape.apispecification.constant.CommonConstants;
import com.warape.apispecification.constant.CommonConstants.ResponseEnum;
import com.warape.apispecification.constant.CommonStatusConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author wanmingyu
 * @create 2020/7/20 5:55 下午
 */
@Slf4j
public abstract class BaseExceptionHandler<R> implements ResponseBodyAdvice<Object> {

  /**
   * 业务异常
   *
   * @param e
   * @return
   */
  @ExceptionHandler(ServiceException.class)
  public R baseExceptionHandler (ServiceException e) {
    if (log.isDebugEnabled()) {
      log.debug(e.getMessage(), e);
    }
    return getResult(e.getCode(), e.getMessage());
  }

  /**
   * 请求参数校验异常
   *
   * @param e
   * @return
   */
  @ExceptionHandler(BindException.class)
  public R bindExceptionHandler (BindException e) {
    String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
    return getResult(CommonConstants.ResponseEnum.ILLEGAL_ARGUMENT.getCode(), message);
  }

  /**
   * 参数绑定异常
   *
   * @param e
   * @return
   */
  @ExceptionHandler(ServletRequestBindingException.class)
  public R requestBindExceptionHandler (ServletRequestBindingException e) {
    return getResult(CommonConstants.ResponseEnum.ILLEGAL_ARGUMENT);
  }

  /**
   * 系统异常
   *
   * @param exception
   * @return
   */
  @ExceptionHandler(Exception.class)
  public R exceptionHandler (Exception exception) {
    log.error("系统异常:", exception);
    return getResult(ResponseEnum.ERROR);
  }

  /**
   * 返回结果
   *
   * @param code
   * @param message
   * @return
   */
  abstract protected R getResult (Integer code, String message);

  /**
   * 返回结果
   *
   * @param commonStatusConstants
   * @return
   */
  private R getResult (CommonStatusConstants<Integer> commonStatusConstants) {
    return getResult(commonStatusConstants.getCode(), commonStatusConstants.getMessage());
  }

  @Override
  public boolean supports (MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    System.out.println(111);
    return true;
  }

  @Override
  public Object beforeBodyWrite (Object body, MethodParameter returnType, MediaType selectedContentType,
      Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
    System.out.println(222);
    return null;
  }
}
