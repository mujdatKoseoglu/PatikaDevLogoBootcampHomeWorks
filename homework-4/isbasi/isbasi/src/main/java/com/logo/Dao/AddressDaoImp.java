package com.logo.Dao;

import com.logo.model.Address;

public interface AddressDaoImp {
    public Address add(Address address);
    public Address update(Integer id,String addressUpdate);
    public Address delete(Integer id);
}
