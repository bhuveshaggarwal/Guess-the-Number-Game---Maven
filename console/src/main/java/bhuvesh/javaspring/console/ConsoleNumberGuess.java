package bhuvesh.javaspring.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ConsoleNumberGuess {

    // == Constants ==
    private final Logger log =  LoggerFactory.getLogger(ConsoleNumberGuess.class);

    @EventListener(ContextRefreshedEvent.class)
    public void Start () {
        log.info("Start() --> Container ready for use.");
    }
}
