package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
public class HelloWorldRestController {

    //@GetMapping Me permite asignarle una URL a cadda funcion
    @GetMapping({"/hello","/hw"})
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/adios")
    public String adios() {
        return "Adios Spring Boot";
    }
}
