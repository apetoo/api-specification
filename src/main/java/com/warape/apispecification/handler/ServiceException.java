package com.warape.apispecification.handler;

import cn.hutool.core.util.StrUtil;
import com.warape.apispecification.constant.CommonStatusConstants;
import lombok.Getter;

/**
 * 统一业务异常
 * @author wanmingyu
 * @create 2020/7/3 5:59 下午
 */
@Getter
public class ServiceException extends RuntimeException {

  private final Integer code;
  private String message;

  public ServiceException (Integer code,String message) {
    super(message);
    this.code = code;
    this.message = message;
  }

  /**
   * eg: new ServiceException(ResponseEnum.ERROR)
   * @param commonStatusConstants
   */
  public ServiceException (CommonStatusConstants<Integer> commonStatusConstants) {
    super(commonStatusConstants.getMessage());
    this.code = commonStatusConstants.getCode();
    this.message = super.getMessage();
  }

  /**
   * eg: new ServiceException(ResponseEnum.ERROR,"失败",new IllegalAccessException())
   * @param commonStatusConstants
   * @param throwable
   */
  public ServiceException (CommonStatusConstants<Integer> commonStatusConstants, Throwable throwable) {
    super(commonStatusConstants.getMessage(), throwable);
    this.code = commonStatusConstants.getCode();
    this.message = super.getMessage();
  }

  /**
   * eg: new ServiceException(ResponseEnum.ERROR,"返回信息为:{},{}","处理","失败")
   * @param commonStatusConstants
   * @param params
   */
  public ServiceException (CommonStatusConstants<Integer> commonStatusConstants, Object... params) {
    super(StrUtil.format(commonStatusConstants.getMessage(), params));
    this.code = commonStatusConstants.getCode();
    this.message = super.getMessage();
  }

  /**
   *
   * eg: new ServiceException(500,"返回信息为:{}","失败")
   * @param code
   * @param messageTemplate
   * @param params
   */
  public ServiceException (Integer code, String messageTemplate, Object... params) {
    super(StrUtil.format(messageTemplate, params));
    this.code = code;
    this.message = super.getMessage();
  }
}