package com.mrk.sbr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mrk.sbr.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
