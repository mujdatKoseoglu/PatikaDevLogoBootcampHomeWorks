package com.movie.service;

import com.movie.client.PaymentClient;
import com.movie.dto.Payment;
import com.movie.model.Movie;
import com.movie.model.User;
import com.movie.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.CurrencyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PaymentClient paymentClient;


    public String createUser(User userRequest){
        //hashing algoritması ile şifrelenmenin yapılması
        String sha256Pass = org.apache.commons.codec.digest.DigestUtils.sha256Hex(userRequest.getPassword());
        userRequest.setPassword(sha256Pass);
        try{
            //kayıt başarılı ise
            User result = userRepository.save(userRequest);
            //ödeme bilgisi
            //Payment payment1=paymentClient.createPayment(new Payment(LocalDateTime.now(), CurrencyType.INSTANCE ,BigDecimal.TEN));
            //log.info(payment1.toString());
            return "Register Success";
        }
            //daha önceden kayıtlı ise
        catch (Exception e){
            return "Login Success";
        }
    }
    public User getByIdUser(Integer idRequest){
        User user1=userRepository.findById(idRequest).get();
        return user1;
    }
    //kullanıcı isim ve şifresinin değiştirilmesi
    public User updateUser(Integer idRequest,User userRequest) {
        User user1=userRepository.findById(idRequest).get();
        user1.setName(userRequest.getName());
        user1.setPassword(userRequest.getPassword());
        userRepository.save(user1);
        return user1;
    }

    public User deleteUser(Integer idRequest) {
        User user1=userRepository.findById(idRequest).get();
        userRepository.delete(user1);
        return user1;
    }
    //kişilerin eklediği filmlerin listesinin gözükmesi
    public List<Movie> getListMovies(Integer idRequest) {
        User user1=userRepository.findById(idRequest).get();
        return user1.getMovieList();
    }
}
