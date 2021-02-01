package com.alkemy.challenge.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String password;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="userprofile" , 
			joinColumns= @JoinColumn(name="idUsers"),
			inverseJoinColumns= @JoinColumn(name="idProfiles"))
	private List<Profiles> profile;
	
	public void agregar(Profiles tempProfiles) {
		if(profile == null) {
			profile = new LinkedList<Profiles>();
		}
		profile.add(tempProfiles);
	}
	
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

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Profiles> getProfile() {
		return profile;
	}

	public void setProfile(List<Profiles> profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", password=" + password + ", profile=" + profile + "]";
	}

   
	
	
}
