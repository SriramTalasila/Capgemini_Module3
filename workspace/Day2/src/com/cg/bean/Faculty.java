package com.cg.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Faculty {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "techId") private Technology technology;
	 */
	// @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "faculty")
	// @JoinTable(name = "factech", joinColumns = @JoinColumn(name = "facid"),
	// inverseJoinColumns = @JoinColumn(name = "techid"))
	private List<Technology> technologies = new ArrayList<Technology>();

	public Faculty() {
		super();
	}

	public Faculty(int id, String name, List<Technology> technologies) {
		super();
		this.id = id;
		this.name = name;
		this.technologies = technologies;
	}

	public Faculty(String name) {
		super();
		this.name = name;
	}

	/*
	 * public Technology getTechnology() { return technology; }
	 * 
	 * public void setTechnology(Technology technology) { this.technology =
	 * technology; }
	 */

	public int getId() {
		return id;
	}

	public List<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + "]";
	}

}
