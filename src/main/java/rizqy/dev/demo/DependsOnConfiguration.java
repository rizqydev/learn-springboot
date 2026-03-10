package rizqy.dev.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import lombok.extern.slf4j.Slf4j;
import rizqy.dev.demo.data.Bar;
import rizqy.dev.demo.data.Foo;

@Configuration
@Slf4j
public class DependsOnConfiguration {
  @Bean
  @DependsOn({
    "bar"
  })
  public Foo foo() {
    log.info("Create Foo");
    return new Foo();
  }

  @Bean
  public Bar bar() {
    log.info("Create Bar");
    return new Bar();
  }
}
