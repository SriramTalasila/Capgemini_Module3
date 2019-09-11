package com.cg.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Technology {
	@Id
	@GeneratedValue
	private int technologyId;
	private String technologyName;
	/*
	 * @OneToOne(mappedBy = "technology") private Faculty faculty;
	 */

	@ManyToOne
	private Faculty faculty;

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Technology() {
		super();

	}

	public Technology(String technologyName) {
		super();
		this.technologyName = technologyName;
	}

	public Technology(int technologyId, String technologyName) {
		super();
		this.technologyId = technologyId;
		this.technologyName = technologyName;
	}

	public int getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	@Override
	public String toString() {
		return "Technology [technologyId=" + technologyId + ", technologyName=" + technologyName + "]";
	}

}
