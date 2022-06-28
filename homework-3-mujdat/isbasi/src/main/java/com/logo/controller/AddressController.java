package com.logo.controller;

import com.logo.model.Address;
import com.logo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    //ekleme
    @PostMapping
    public String createAddress(@RequestBody Address addressRequest){
         addressService.createAddress(addressRequest);
         return addressRequest.getCountry() + " has been recorded ";

    }
    //country'e göre bulma
    @GetMapping("/{addresscountry}")
    public Address getByCountryAddress(@PathVariable("addresscountry") String addresscountry){
        return addressService.getByCountryAddress(addresscountry);
    }
    //güncelleme
    @PutMapping("/{addresscountry}")
    public Address updateAddress(@PathVariable("addresscountry")String addresscountry,@RequestBody Address address){
        return addressService.updateAddress(addresscountry,address);
    }
    @DeleteMapping("/{addresscountry}")
    public Address deleteAddress(@PathVariable("addresscountry")String addresscountry){
        return addressService.deleteAddress(addresscountry);
    }
    //silme
    @GetMapping
    public List<Address> listAll(){
        return addressService.listAll();
    }

}
