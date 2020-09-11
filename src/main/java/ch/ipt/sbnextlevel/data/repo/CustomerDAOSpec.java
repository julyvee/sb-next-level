package ch.ipt.sbnextlevel.data.repo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import ch.ipt.sbnextlevel.data.model.CustomerEntity;
import ch.ipt.sbnextlevel.data.model.CustomerEntity_;

public class CustomerDAOSpec implements Specification<CustomerEntity> {

    /**
     *
     */
    private static final long serialVersionUID = 5394425864068528678L;
    private Specification<CustomerEntity> specification;

    public CustomerDAOSpec() {
        specification = (root, query, builder) -> builder.equal(builder.literal(1), 1);
    }

    public CustomerDAOSpec firstNameStartsWith(String firstName) {
        if (!StringUtils.isEmpty(firstName)) {
            specification = specification
                    // The % character matches zero or more of any character (like .* in regex)
                    .and((root, query, builder) -> builder.like(root.get(CustomerEntity_.firstName), firstName + "%"));
        }
        return this;
    }

    public CustomerDAOSpec lastNameStartsWith(String lastName) {
        if (!StringUtils.isEmpty(lastName)) {
            specification = specification
                    // The % character matches zero or more of any character (like .* in regex)
                    .and((root, query, builder) -> builder.like(root.get(CustomerEntity_.lastName), lastName + "%"));
        }
        return this;
    }

    public CustomerDAOSpec ageGreaterThan(Integer minAge) {
        if (minAge != null) {
            specification = specification
                    // The % character matches zero or more of any character (like .* in regex)
                    .and((root, query, builder) -> builder.greaterThanOrEqualTo(root.get(CustomerEntity_.age), minAge));
        }
        return this;
    }

    public CustomerDAOSpec ageLessThan(Integer maxAge) {
        if (maxAge != null) {
            specification = specification
                    // The % character matches zero or more of any character (like .* in regex)
                    .and((root, query, builder) -> builder.lessThanOrEqualTo(root.get(CustomerEntity_.age), maxAge));
        }
        return this;
    }

    @Override
    public Predicate toPredicate(Root<CustomerEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return specification.toPredicate(root, query, criteriaBuilder);
    }

}