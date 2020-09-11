package ch.ipt.sbnextlevel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ch.ipt.sbnextlevel.data.model.CustomerEntity;
import ch.ipt.sbnextlevel.data.repo.CustomerDAO;
import ch.ipt.sbnextlevel.data.repo.CustomerDAOSpec;
import ch.ipt.sbnextlevel.exception.model.CustomerNotFoundException;
import ch.ipt.sbnextlevel.model.Customer;

@Service
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private ModelMapper modelMapper;

    public Customer getCustomerById(int id) throws CustomerNotFoundException {

        LOGGER.info("Get Customer called for id {}", id);

        Optional<CustomerEntity> dbResult = customerDAO.findById(id);

        if (!dbResult.isPresent()) {
            LOGGER.info("Customer with id {} not found.", id);
            throw new CustomerNotFoundException("Customer was not found",
                    "No customer was found with this id. Try again with a different id.");
        }

        LOGGER.debug("Customer found for id {}: {}", id, dbResult.get());
        return modelMapper.map(dbResult.get(), Customer.class);
    }

    public List<Customer> findCustomersByFilters(String firstName, String lastName, int minAge, int maxAge) {

        Specification<CustomerEntity> spec = new CustomerDAOSpec().firstNameStartsWith(firstName)
                .lastNameStartsWith(lastName).ageGreaterThan(minAge).ageLessThan(maxAge);

        List<CustomerEntity> dbResult = customerDAO.findAll(spec);
        List<Customer> customers = new ArrayList<>();

        for (CustomerEntity customerEntity : dbResult) {
            Customer customer = modelMapper.map(customerEntity, Customer.class);
            LOGGER.debug("Customer found for id {}: {}", customerEntity.getId(), customer);
            customers.add(customer);
        }

        return customers;
    }

}