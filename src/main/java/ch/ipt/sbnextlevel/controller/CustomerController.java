package ch.ipt.sbnextlevel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.ipt.sbnextlevel.exception.model.CustomerNotFoundException;
import ch.ipt.sbnextlevel.exception.model.InvalidQueryException;
import ch.ipt.sbnextlevel.model.Customer;
import ch.ipt.sbnextlevel.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id)
            throws InvalidQueryException, CustomerNotFoundException {
        if (id < 0) {
            throw new InvalidQueryException("Id has to be > 0",
                    "Query is invalid because the path parameter id has to be >0. Try again with a different id.");
        }

        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    // http://localhost:8080/customers?firstName=Hans&lastName=Zimmer
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findCustomersByFilters(@RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false, defaultValue = "0") int minAge,
            @RequestParam(required = false, defaultValue = "0") int maxAge) {
        List<Customer> customers = customerService.findCustomersByFilters(firstName, lastName, minAge, maxAge);
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

}