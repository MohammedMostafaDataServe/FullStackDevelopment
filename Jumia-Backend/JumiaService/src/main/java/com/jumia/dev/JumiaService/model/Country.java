package com.jumia.dev.JumiaService.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "country")
@Data
public class Country {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;
	
	@OneToMany(mappedBy = "country")
	private Set<State> states;

	public Country() {

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(code, other.code) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(states, other.states);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, id, name, states);
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", code=" + code + ", states=" + states + "]";
	}

}
