package ch.bs.hug.springjenkinsdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @GetMapping(value = "/hello")
  public String hello(){
    return "Hello there";
  }
}
