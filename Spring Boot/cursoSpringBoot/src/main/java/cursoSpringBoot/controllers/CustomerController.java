package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123,"Gerardo Lopez", "gerardo1", "contraseña123"),
            new Customer(456, "Alejandra Garcia", "alegarcia","clave456"),
            new Customer(789,"Laura Sanchez","lauras","secreto789"),
            new Customer(234,"Carlos Martinez", "carlosm", "password234")
    ));


    //Obtiene los clientes que hay en la aplicaciones
    @GetMapping("/clientes")
    public List<Customer> getCustomers() {
        return customers;
    }

    //Obtiene solo un cliente en especifico
    @GetMapping("/clientes/{username}")
    public Customer getCustomer(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null; //Mala practica, hay que mostrar un error 404
    }

    // Metodo para agregar mas clientes
    @PostMapping("/clientes")
    public Customer postCliente(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

}
