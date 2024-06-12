package com.prog.restbook.repository;

import com.prog.restbook.model.AccountDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AccountRepository extends JpaRepository<AccountDetail, Long> {
    List<AccountDetail> findByActive(boolean active);
}