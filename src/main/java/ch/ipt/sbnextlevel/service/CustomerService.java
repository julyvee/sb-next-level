package ch.ipt.sbnextlevel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.ipt.sbnextlevel.data.model.CustomerEntity;
import ch.ipt.sbnextlevel.data.repo.CustomerDAO;
import ch.ipt.sbnextlevel.model.Customer;

@Service
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private ModelMapper modelMapper;

    public Customer getCustomerById(int id) {

        LOGGER.info("Get Customer called for id {}", id);
        // TODO: Use Exception Handling to validate input parameters and handle empty
        // responses

        Optional<CustomerEntity> dbResult = customerDAO.findById(id);

        if (dbResult.isPresent()) {
            LOGGER.info("Customer found for id {}: {}", id, dbResult.get());
            return modelMapper.map(dbResult.get(), Customer.class);
        } else {
            LOGGER.info("Customer with id {} not found.", id);
            return null;
        }
    }

    public List<Customer> getAllCustomers() {
        List<CustomerEntity> dbResult = customerDAO.findAll();
        List<Customer> customers = new ArrayList<>();

        for (CustomerEntity customerEntity : dbResult) {
            Customer customer = modelMapper.map(customerEntity, Customer.class);
            customers.add(customer);
        }

        if (customers.isEmpty()) {
            LOGGER.debug("No Customers found.");
        }

        return customers;
    }

    public List<Customer> findCustomersByFilters(String firstName, String lastName, int minAge, int maxAge) {
        // TODO: Optional - Use Exception Handling to validate input parameters

        // TODO: Build the specification
        // Specification<CustomerEntity> spec =
        // List<CustomerEntity> dbResult = customerDAO.findAll(spec);
        List<Customer> customers = new ArrayList<>();

        // for (CustomerEntity customerEntity : dbResult) {
        // Customer customer = modelMapper.map(customerEntity, Customer.class);
        // customers.add(customer);
        // }

        return customers;
    }

}