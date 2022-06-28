package com.logo.repository;

import com.logo.model.Address;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressRepository {
    //ürünlerimizi saklayabileceğimiz bir liste oluşturduk
    static List<Address> addressList = new ArrayList<Address>();
    //listemize bir adres ekledik
    public AddressRepository(){
        addressList.add(new Address("İtalya","Roma","Trevi"));
    }
    //adres oluşturma metodumuz
    public Address create(Address addressRequest) {
        addressList.add(addressRequest);
        return addressRequest;

    }
    //ülkeye göre adres getirme metodumuz
    public Address getByCountryAddress(String countryRequest){
        return addressList.stream().filter(address -> address.getCountry().equals(countryRequest)).findFirst().orElseThrow();
    }
    //adres güncelleme metodumuz
    public Address updateAddress(String country, Address address) {
        Address address1=addressList.stream().filter(k->k.getCountry().equals(country)).findFirst().orElseThrow();
        address1.setAddress(address.getAddress());
        address1.setCountry(address.getCountry());
        address1.setProvince(address.getProvince());
        return address1;
    }
    //adres silme metodumuz
    public Address deleteAddress(String country) {
        Address address1=addressList.stream().filter(k->k.getCountry().equals(country)).findFirst().orElseThrow();
        addressList.remove(address1);
        return address1;
    }
    //tüm adreslerin listesini geri döndüren metodumuz
    public List<Address> getAll() {
        return addressList;
    }
}
