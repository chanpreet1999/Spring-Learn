package com.example.demo.model;

import java.util.Date;

public class TodoBean implements ITodoBean {

	private int id;
	private String name;
	private String desc;
	private Date targetDate;
	private boolean complete;
	
	public TodoBean(int id, String name, String desc, Date targetDate, boolean complete) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.targetDate = targetDate;
		this.complete = complete;
	}
	
	@Override
	public String toString() {
		return "TodoBean [id=" + id + ", name=" + name + ", desc=" + desc + ", targetDate=" + targetDate
				+ ", isComplete=" + complete + "]";
	}
	@Override
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	
	@Override
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	 @Override
    public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null) {
	        return false;
	    }
	    if (getClass() != obj.getClass()) {
	        return false;
	    }
	    TodoBean other = (TodoBean) obj;
	    if (id != other.id) {
	        return false;
	    }
	    return true;
	   }
	
	
}
