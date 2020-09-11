package ch.ipt.sbnextlevel.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import ch.ipt.sbnextlevel.data.model.CustomerEntity;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity, Integer>, JpaSpecificationExecutor<CustomerEntity> {

}