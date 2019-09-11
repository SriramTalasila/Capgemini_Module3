package com.cg.bean;

import javax.persistence.Entity;

@Entity

public class Temporary extends Employee2 {
	private float dailyWage;

	public float getDailyWage() {
		return dailyWage;
	}

	public void setDailyWage(float dailyWage) {
		this.dailyWage = dailyWage;
	}

}
