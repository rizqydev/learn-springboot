package rizqy.dev.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import rizqy.dev.demo.data.Foo;

@Slf4j
@Configuration
public class BeanConfiguration {

  @Bean
  public Foo foo() {
    Foo foo = new Foo();

    log.info("create new foo");

    return foo;
  }
}
