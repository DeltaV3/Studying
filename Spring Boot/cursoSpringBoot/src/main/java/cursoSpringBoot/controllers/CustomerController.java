package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/clientes") //URL Para toda la clase
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123,"Gerardo Lopez", "gerardo1", "contraseña123"),
            new Customer(456, "Alejandra Garcia", "alegarcia","clave456"),
            new Customer(789,"Laura Sanchez","lauras","secreto789"),
            new Customer(234,"Carlos Martinez", "carlosm", "password234")
    ));


    //Obtiene los clientes que hay en la aplicaciones
    //@RequestMapping(method = RequestMethod.GET) //Ejemplo de URL para metodos, es mas explicito
    @GetMapping
    public List<Customer> getCustomers() {
        return customers;
    }

    //Obtiene solo un cliente en especifico
    //@RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public Customer getCustomer(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null; //Mala practica, hay que mostrar un error 404
    }

    // Metodo para agregar mas clientes
    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping //Post Agregar
    public Customer postCliente(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping //Put Modificar
    public Customer putCliente(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if(c.getId() == customer.getId()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return c;
            }
        }
        return null;
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public Customer deleteCliente(@PathVariable int id) {
        for (Customer c : customers) {
            if(c.getId() == id) {
                customers.remove(c);

                return c;
            }
        }
        return null; //Error
    }

    //@RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public Customer patchCliente(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if(c.getId() == customer.getId()) {

                if(customer.getName() != null) {
                    c.setName(customer.getName());
                }

                if(customer.getUsername() != null) {
                    c.setUsername(customer.getUsername());
                }

                if(customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }

                return c;
            }
        }
        return null; // Pesima practica
    }
}
