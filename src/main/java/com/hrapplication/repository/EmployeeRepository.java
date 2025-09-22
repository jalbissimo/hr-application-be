package com.hrapplication.repository;

import com.hrapplication.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);

    @Query("""
               select e from Employee e
               left join fetch e.department
               left join fetch e.manager
            """)
    List<Employee> findAllWithRelations();
}