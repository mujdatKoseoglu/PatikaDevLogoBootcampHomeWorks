package com.logo.service;

import com.logo.Dao.AddressDaoImp;
import com.logo.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressDaoImp addressDao;

//    @Autowired
//    private JdbcDao jdbcDao;
//
//    @Autowired
//    private JdbcTemplateDao jdbcTemplateDao;

    //adres oluşturma metodu
    public Address createAddress(Address addressRequest){

        return addressDao.add(addressRequest);
    }
    //güncelleme
    public Address updateAddress(Address address) {
        Address address1= addressDao.update(address.getId(), address.getAddress());
        address1.setCountry(address.getCountry());
        address1.setProvince(address.getProvince());
        address1.setAddress(address.getAddress());
        return addressDao.add(address1);
    }
    //silme işlemi
    public void deleteAddress(Integer idrequest) {
        Address address1 = addressDao.delete(idrequest);
        addressDao.delete(idrequest);
        System.out.println(idrequest+" no lu id silindi");
    }

}
