package PAYSURA.IPC;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@EnableNeo4jRepositories
public class App {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

}