package com.jumia.dev.JumiaService.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * State Entity
 * 
 * @author Mohammed Mostafa
 *
 */
@Entity
@Table(name = "state")
@Data
public class State {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "country_id")
	@JsonIgnore
	private Country country;
	
	@OneToMany(mappedBy = "state")
	private Set<Customer> customer;

	public State() {

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		return Objects.equals(country, other.country) && Objects.equals(customer, other.customer) && id == other.id
				&& Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, customer, id, name);
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", country=" + country + ", customer=" + customer + "]";
	}

}
