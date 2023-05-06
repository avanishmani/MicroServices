package com.mrTripathi.model;

import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
@Entity
@Data
@Table(name = "micro_user")
public class Users {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer UserId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ABOUT")
	private String about;
	@Transient
	private List<Rating> rating;
}
