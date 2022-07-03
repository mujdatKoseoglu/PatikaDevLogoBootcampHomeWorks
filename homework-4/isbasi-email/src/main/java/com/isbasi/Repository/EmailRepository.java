package com.isbasi.Repository;

import com.isbasi.Dto.EmailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailDto,Integer> {
}
