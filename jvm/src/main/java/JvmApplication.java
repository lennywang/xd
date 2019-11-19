import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 **/
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ch09_pritice")
public class JvmApplication {
    public static void main(String[] args) {
        SpringApplication.run(JvmApplication.class,args);
    }
}
