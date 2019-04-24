/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hi.jooby;

import org.jooby.Jooby;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App extends Jooby {
    Logger logger = LoggerFactory.getLogger(App.class);

    {
        get(req -> {
            String name = req.param("name").value("Jooby");
            logger.info("request served");
            return "Hello " + name + "!";
        });
    }

    public static void main(String[] args) {
        run(App::new, args);
    }
}
