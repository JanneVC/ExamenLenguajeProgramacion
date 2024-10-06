package com.cibertec.model;

public class Subject {
	private int idsubject;
	private String subject;
	private String credits;
	
	public Subject(int idsubject, String subject, String credits) {
		this.idsubject = idsubject;
		this.subject = subject;
		this.credits = credits;
	}

	public Subject(String subject, String credits) {
		this.subject = subject;
		this.credits = credits;
	}
	
	public Subject() {}

	public int getIdsubject() {
		return idsubject;
	}

	public void setIdsubject(int idsubject) {
		this.idsubject = idsubject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}	
}
