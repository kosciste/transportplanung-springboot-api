package ch.viollier.transportplanung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
@RestController
public class Main {
    public static  void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public Group greet(){
        return new Group(List.of(new Person("Stefan"), new Person("Milica")));
    }

    @GetMapping("/kleinefroschelein")
    public String kleinefroschelein(){
        return "Dasischmicasundstefossite";
    }
    record Person(String name){}

    record Group(List<Person> ps){}


}
