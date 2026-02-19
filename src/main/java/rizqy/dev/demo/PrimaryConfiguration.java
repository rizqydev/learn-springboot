package rizqy.dev.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import rizqy.dev.demo.data.Foo;

public class PrimaryConfiguration {

  @Primary
  @Bean
  public Foo foo1() {
    return new Foo();
  }

  @Bean
  public Foo foo2() {
    return new Foo();
  }
}
