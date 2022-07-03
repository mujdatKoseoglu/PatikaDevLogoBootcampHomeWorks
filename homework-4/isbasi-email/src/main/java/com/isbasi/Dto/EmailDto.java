package com.isbasi.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Documented;
import java.util.Collection;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public class EmailDto {
        private String to;
        private  String title;
        private  String email;
}
