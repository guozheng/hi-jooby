package hi.jooby.module;

import com.google.inject.Binder;
import com.typesafe.config.Config;
import org.jooby.Env;
import org.jooby.Jooby;
import org.jooby.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SayHiModule implements Jooby.Module {
    Logger logger = LoggerFactory.getLogger(SayHiModule.class);

    /**
     * Configure and produces bindings for the underlying application. A module can optimize or
     * customize a service by checking current the {@link Env application env} and/or the current
     * application properties available from {@link Config}.
     *
     * @param env    The current application's env. Not null.
     * @param conf   The current config object. Not null.
     * @param binder A guice binder. Not null.
     * @throws Throwable If something goes wrong.
     */
    @Override
    public void configure(Env env, Config conf, Binder binder) throws Throwable {
        Router router = env.router();
        String name = conf.getString("name");
        router.get("/hi", () -> "hi, " + name);
    }
}
