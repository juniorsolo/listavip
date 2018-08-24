package br.com.listavip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.listavip.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByName(String name);
}
