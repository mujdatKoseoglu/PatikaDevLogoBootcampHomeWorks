package com.email.Model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "emails")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String to;
    private  String title;
    private  String email;
}
