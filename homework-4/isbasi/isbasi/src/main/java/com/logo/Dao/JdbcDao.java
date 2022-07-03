package com.logo.Dao;

import com.logo.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
//bu class'ı kullanacağımız zaman @service anotasyonunu ekleyeceğiz
public class JdbcDao implements AddressDaoImp{
    @Autowired
    private AddressJpaRepository addressJpaRepository;

    public JdbcDao(AddressJpaRepository addressJpaRepository) {
        this.addressJpaRepository = addressJpaRepository;
    }
    //ekleme
    public Address add(Address address){
        System.out.println("Jdbc addres ekleniliyor : " + address.getAddress());

        this.addressJpaRepository.save(address);

        System.out.println("addres eklenildi.." + address.getAddress());
        return address;
    }
    //güncelleme
    public Address update(Integer id,String addressUpdate){

        Address address = this.addressJpaRepository.getById(id);
        address.setAddress(addressUpdate);

        this.addressJpaRepository.save(address);
        return address;
    }
    //silme
    public Address delete(Integer id){
        Address address=this.addressJpaRepository.getById(id);
        this.addressJpaRepository.deleteById(id);
        return address;

    }
}
