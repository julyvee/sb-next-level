package ch.ipt.sbnextlevel.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import ch.ipt.sbnextlevel.data.model.CustomerEntity;
import ch.ipt.sbnextlevel.model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity, Integer>, JpaSpecificationExecutor<CustomerEntity> {

    public List<Customer> findByAgeGreaterThanAndAgeLessThanAndfirstNameLikeAndLastNameLike(int minAge, int maxAge,
            String firstName, String lastName);
}