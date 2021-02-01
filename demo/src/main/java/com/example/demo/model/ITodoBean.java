package com.example.demo.model;

import java.util.Date;

public interface ITodoBean {

	int getId();

	String getName();

	String getDesc();

	Date getTargetDate();
	boolean isComplete();
}
