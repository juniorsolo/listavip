package br.com.listavip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.listavip.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUserName(String userName);
}
