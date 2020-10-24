package com.warape.apispecification.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author wanmingyu
 * @create 2020/10/23 5:05 下午
 */
public class BaseResult {

  @JsonIgnore
  private List<Integer> systemCodeList = new ArrayList<>();

  public List<Integer> getSystemCodeList () {
    return systemCodeList;
  }

  public void setSystemCodeList (List<Integer> systemCodeList) {
    this.systemCodeList = systemCodeList;
  }

}
