package com.warape.apispecification.constant;

/**
 * 统一响应或请求编码和信息顶层接口
 * @author wanmingyu
 * @create 2020/6/28 6:07 下午
 */
public interface CommonStatusConstants<T> {

  /**
   * 响应编码
   * @return T
   */
  T getCode ();

  /**
   * 响应信息
   * @return String
   */
  String getMessage ();

  /**
   * 判断状态
   * @param code T
   * @return boolean
   */
  default boolean equalsCode(T code){
    return getCode().equals(code);
  }
}
