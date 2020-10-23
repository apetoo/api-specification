package com.warape.apispecification.controller;

import com.warape.apispecification.response.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanmingyu
 * @create 2020/10/20 6:29 下午
 */
@RestController
@RequestMapping(value = {"services/user", "/services/api/user"})
public class ResultDemoController {


  @GetMapping("/getUserInfo")
  public ApiResult<Integer> getUserInfo () {
    return null;
  }



}
