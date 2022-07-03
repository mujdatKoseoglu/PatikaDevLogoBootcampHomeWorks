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
    public Address createAddress(@RequestBody Address addressRequest){
         return addressService.createAddress(addressRequest);
         //return addressRequest.getCountry() + " has been recorded ";
    }

    //güncelleme
    @PutMapping
    public Address updateAddress(@RequestBody Address address){

        return addressService.updateAddress(address);
    }

    //silme
    @DeleteMapping("/{idrequest}")
    public String deleteAddress(@PathVariable Integer idrequest){
        addressService.deleteAddress(idrequest);
        return idrequest+"'id li kayıt silindi";
    }


}
