package quarkus.extension.dynamic.config;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class StartupEventListener {

    @Inject
    private Config beanManager;

    public void startEvent(@Observes StartupEvent ev) throws InterruptedException {
        for (; ; ) {
            String aLong = beanManager.email.get();
            System.out.println(aLong);
            Thread.sleep(1000);
        }
    }
}
