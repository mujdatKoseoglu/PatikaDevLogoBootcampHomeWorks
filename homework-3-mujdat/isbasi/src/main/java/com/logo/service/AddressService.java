package com.logo.service;

import com.logo.model.Address;
import com.logo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    //adres oluşturma metodu
    public Address createAddress(Address addressRequest){
        return addressRepository.create(addressRequest);
    }
    //ülkeye göre addresi geri döndürme metodu
    public Address getByCountryAddress(String countryRequest) {
        return addressRepository.getByCountryAddress(countryRequest);
    }
    //address güncelleme metodu
    public Address updateAddress(String country, Address address) {

        return addressRepository.updateAddress(country,address);
    }
    //address silme metodu
    public Address deleteAddress(String country) {
        return addressRepository.deleteAddress(country);
    }
    //bütün adreslerin listesini geri döndüren metod
    public List<Address> listAll() {
        return addressRepository.getAll();
    }
}
