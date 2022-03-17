package ch.bs.hug.springjenkinsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAutoConfiguration
@EnableWebMvc
@Configuration
@ComponentScan
public class SpringJenkinsDemoApplication {

  public static void main (String[] args) {
    SpringApplication.run(SpringJenkinsDemoApplication.class, args);
  }

}
