package com.cg;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

public class SqlDateEditor extends PropertyEditorSupport{
	
	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		return getValue().toString();
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text.equalsIgnoreCase("getDate()")) {
			setValue((new Date(System.currentTimeMillis())));
		}
		else {
			setValue(Date.valueOf(text));
		}
	}
	
}
