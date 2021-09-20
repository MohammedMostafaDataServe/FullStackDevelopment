package com.jumia.dev.JumiaService.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jumia.dev.JumiaService.validation.PhoneNumberConstraint;

import lombok.Data;

/**
 * Customer Entity
 * 
 * @author Mohammed Mostafa
 *
 */
@Entity
@Table(name = "customer")
@Data
public class Customer {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	@NotBlank(message = "Name is mandatory")
	private String name;

	@Column(name = "phone")
	@NotBlank(message = "Phone is mandatory")
	@PhoneNumberConstraint
	private String phone;

	@ManyToOne
	@JoinColumn(name = "state_id")
	@JsonIgnore
	private State state;

	public Customer() {

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
				&& Objects.equals(state, other.state);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, phone, state);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", state=" + state + "]";
	}

}
