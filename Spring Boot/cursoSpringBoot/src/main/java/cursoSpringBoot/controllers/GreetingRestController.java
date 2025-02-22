package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

    //@PathVariable Me permite conseguir las variables directamente de la URL con ayuda de GetMapping
    @GetMapping({"/saludo/{name}" , "/hello/{name}"})
    public String greeting(@PathVariable String name) {
        return "Hello " + name;
    }

}
