package to.rxs.kore.api;

import lombok.extern.flogger.Flogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import reactor.core.publisher.Hooks;

@Flogger
@EnableConfigurationProperties
@ComponentScan("to.rxs")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        Hooks.onOperatorDebug();
        SpringApplication.run(Application.class, args);
    }
}
