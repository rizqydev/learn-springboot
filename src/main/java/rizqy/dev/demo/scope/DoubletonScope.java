package rizqy.dev.demo.scope;

import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class DoubletonScope implements Scope {
  private List<Object> objects = new ArrayList<>(2);
  private Long counter = -1L;

  @Override
  public Object get(String name, ObjectFactory<?> objectFactory) {
    counter++;

    if (objects.size() == 2) {
      return objects.get((int) (counter % 2));
    } else {
      Object object = objectFactory.getObject();
      objects.add(object);

      return object;
    }
  }

  @Override
  public void registerDestructionCallback(String name, Runnable callback) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public @Nullable Object remove(String arg0) {
    if (!objects.isEmpty()) {
      return objects.remove(0);
    }
    return null;
  }
  

}
