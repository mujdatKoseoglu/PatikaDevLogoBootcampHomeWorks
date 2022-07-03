package com.logo.Dao;

import com.logo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressJpaRepository extends JpaRepository<Address,Integer> {

}
