package ch.ipt.sbnextlevel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.ipt.sbnextlevel.data.model.CustomerEntity;
import ch.ipt.sbnextlevel.data.repo.CustomerDAO;
import ch.ipt.sbnextlevel.model.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private ModelMapper modelMapper;

    public Customer getCustomerById(int id) {
        Optional<CustomerEntity> dbResult = customerDAO.findById(id);

        if (dbResult.isPresent()) {
            return modelMapper.map(dbResult, Customer.class);
        }

        return null;
    }

    public List<Customer> findCustomersByFilters(String firstName, String lastName, int minAge, int maxAge) {
        List<CustomerEntity> dbResult = customerDAO.findAll();
        List<Customer> customers = new ArrayList<>();

        for (CustomerEntity customerEntity : dbResult) {
            Customer customer = modelMapper.map(customerEntity, Customer.class);
            customers.add(customer);
        }

        return customers;
    }

}