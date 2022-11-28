package com.ems.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	public Login findByUserNameAndPassword(String userName, String password);

}
