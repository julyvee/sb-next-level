package ch.ipt.sbnextlevel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.ipt.sbnextlevel.model.Customer;
import ch.ipt.sbnextlevel.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public Customer addNewCustomer(@RequestBody Customer customer) {
        System.out.println("Saved customer: " + customer);
        return customer;
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    // http://localhost:8088/buecher?name=1&seiten=123
    @GetMapping("/customers")
    public List<Customer> findCustomersByFilters(@RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false, defaultValue = "0") int minAge,
            @RequestParam(required = false, defaultValue = "0") int maxAge) {
        return customerService.findCustomersByFilters(firstName, lastName, minAge, maxAge);
    }
}