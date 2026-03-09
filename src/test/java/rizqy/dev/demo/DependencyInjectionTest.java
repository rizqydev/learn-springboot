package rizqy.dev.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import rizqy.dev.demo.data.Bar;
import rizqy.dev.demo.data.Foo;
import rizqy.dev.demo.data.FooBar;

public class DependencyInjectionTest {

  private ApplicationContext applicationContext;

  @BeforeEach
  void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
  }

  @Test
  void testDI() {
    Foo foo = applicationContext.getBean("fooSecond", Foo.class);
    Bar bar = applicationContext.getBean(Bar.class);
    FooBar foobar = applicationContext.getBean(FooBar.class);

    Assertions.assertSame(foo, foobar.getFoo());
    Assertions.assertSame(bar, foobar.getBar());
  }


  @Test
  void testNoDI() {
    var foo = new Foo();
    var bar = new Bar();
    var foobar = new FooBar(foo, bar);

    Assertions.assertNotNull(foobar);
    Assertions.assertSame(foo, foobar.getFoo());
    Assertions.assertSame(bar, foobar.getBar());
  }
}
