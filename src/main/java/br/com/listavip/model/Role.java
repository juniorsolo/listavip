package br.com.listavip.model;

import java.util.Set;

import javax.persistence.ManyToMany;

public class Role {
	
	private Integer id;
	private String name;
	@ManyToMany(mappedBy="roles")
	private Set<User> users;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
