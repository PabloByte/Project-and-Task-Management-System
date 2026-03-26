package com.beforesecurity.beforesecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beforesecurity.beforesecurity.model.UserAccount;

@Repository
public interface UsserAccountRepository  extends  JpaRepository<UserAccount, Long>{



         Boolean existsByEmail (String email);

  Optional<UserAccount> findByUserName (String userName); // con este metodo verifico el user name en el login
  Optional<UserAccount> findByEmail (String email);


















}
