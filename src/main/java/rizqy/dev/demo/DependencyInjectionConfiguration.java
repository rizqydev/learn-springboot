package rizqy.dev.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rizqy.dev.demo.data.Bar;
import rizqy.dev.demo.data.Foo;
import rizqy.dev.demo.data.FooBar;

@Configuration
public class DependencyInjectionConfiguration {

  @Bean
  public Foo foo() {
    return new Foo();
  }

  @Bean
  public Bar bar() {
    return new Bar();
  }

  @Bean
  public FooBar fooBar() {
    return new FooBar(foo(), bar());
  }

}
