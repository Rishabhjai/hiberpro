package com.tut.hiberpro;

import java.nio.file.attribute.FileTime;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Index;
@Entity
public class History {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column()
	String event;
	
	String starttime;
	String endtime;
	
	String success;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String string) {
		this.starttime = string;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String string) {
		this.endtime = string;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String string) {
		this.success = string;
	}

	
}
