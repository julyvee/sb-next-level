package ch.ipt.sbnextlevel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.ipt.sbnextlevel.model.Customer;
import ch.ipt.sbnextlevel.service.CustomerService;

@RestController
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/{id}")
    public Customer getCustomerByIdSimple(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    // @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {

        if (id < 0) {
            LOGGER.info("Negative id {} not allowed.", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer customer = customerService.getCustomerById(id);

        if (customer != null) {
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // http://localhost:8080/customers?firstName=Hans&lastName=Zimmer
    // @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findCustomersByFilters(@RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false, defaultValue = "0") int minAge,
            @RequestParam(required = false, defaultValue = "0") int maxAge) {

        List<Customer> customers = customerService.findCustomersByFilters(firstName, lastName, minAge, maxAge);
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

}