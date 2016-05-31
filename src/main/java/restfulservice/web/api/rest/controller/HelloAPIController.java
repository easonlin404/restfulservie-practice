package restfulservice.web.api.rest.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mockapp.EchoClient;

/**
 *
 * @author Eason Lin
 *
 */
@RestController
@RequestMapping(value = "/rest")
public class HelloAPIController {

  @RequestMapping(value = "/hello", method = RequestMethod.POST)
  @ResponseBody
  public String sayHello(@RequestParam(value="name", defaultValue="easonlin") String name ) throws IOException {
    // 去remote app 取得資料
    // 使用socket 連線
    EchoClient client = new EchoClient();
    return client.sayHello(name);
  }








}
