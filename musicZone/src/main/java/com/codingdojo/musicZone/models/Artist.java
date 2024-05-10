package com.codingdojo.musicZone.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "artists")
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 45, message = "Title doesnt meet our validations")
	private String name;
	
	@NotNull
	@Min(1)
//	@Max(12)
	private int numOfMembers;
	
	@NotNull
	private boolean stillTouring;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
	public Artist() {
	}
	
	public Artist(String name, int numOfMembers,
			boolean stillTouring) {
		this.name = name;
		this.numOfMembers = numOfMembers;
		this.stillTouring = stillTouring;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumOfMembers() {
		return numOfMembers;
	}
	public void setNumOfMembers(int numOfMembers) {
		this.numOfMembers = numOfMembers;
	}
	public boolean isStillTouring() {
		return stillTouring;
	}
	public void setStillTouring(boolean stillTouring) {
		this.stillTouring = stillTouring;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
	
}
