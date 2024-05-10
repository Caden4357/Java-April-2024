package com.codingdojo.ninjaGold.models;

public class Note {
	private String note;
	private String styleClass;
	
	public Note() {
	}

	public Note(String note, String styleClass) {
		this.note = note;
		this.styleClass = styleClass;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	
	

}
