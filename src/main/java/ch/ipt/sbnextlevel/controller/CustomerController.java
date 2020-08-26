package ch.ipt.sbnextlevel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ch.ipt.sbnextlevel.model.Customer;
import ch.ipt.sbnextlevel.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/{id}")
    // public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
    public Customer getCustomerById(@PathVariable Integer id) {
        // Customer customer = customerService.getCustomerById(id);
        // return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        // String requestId = UUID.randomUUID().toString();
        // MDC.put("REQ_ID", requestId);

        return customerService.getAllCustomers();
    }

    // http://localhost:8080/customers?firstName=Hans&lastName=Zimmer
    /*
     * @GetMapping("/customers") public List<Customer>
     * findCustomersByFilters(@RequestParam(required = false) String firstName,
     * 
     * @RequestParam(required = false) String lastName,
     * 
     * @RequestParam(required = false, defaultValue = "0") int minAge,
     * 
     * @RequestParam(required = false, defaultValue = "0") int maxAge) { return
     * customerService.findCustomersByFilters(firstName, lastName, minAge, maxAge);
     * }
     */
}