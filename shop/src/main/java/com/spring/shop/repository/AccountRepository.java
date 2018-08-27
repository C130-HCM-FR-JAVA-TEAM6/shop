package com.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.spring.shop.model.Account;
import java.lang.String;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface AccountRepository extends JpaRepository<Account, Long>{
	@Query("select a from Account a where a.userName = :user_name and a.password = :password")
	Account findByUserNameAndPassword(@Param("user_name") String username,@Param("password") String password);
	@Query("select a from Account a where a.userName = :user_name")
	Account findByUserName(@Param("user_name") String username);
}
