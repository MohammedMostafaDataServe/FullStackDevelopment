package com.jumia.dev.JumiaService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jumia.dev.JumiaService.model.Customer;
/**
 * Customer Repository interface for customer db operations
 * 
 * @author Mohammed Mostafa
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
