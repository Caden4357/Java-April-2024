package com.codingdojo.mockexam.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "artists")
public class Artist{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// add additional attributes that are needed
	@NotEmpty(message = "name is required!")
	@Size(min = 3, max = 45, message = "name must be between 3 and 30 characters")
	private String name;
	
	@NotNull
	@Min(value = 0, message = "cant have negative number of albums")
	@Max(value = 100, message = "Cant have more than 100 albums")
	private int numOfAlbums;
	
	@NotEmpty(message = "genre is required!")
	@Size(min = 3, max = 45, message = "genre must be between 3 and 30 characters")
	private String genre;
	
	private Boolean stillTouring;
	
	// generate constructors + getters and setters
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
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    private List<Comment> comments;
    
    
	public Artist() {
	}
	
	
//	Delete to test if needed in project once everything is working as expected
	public Artist(
			@NotEmpty(message = "name is required!") @Size(min = 3, max = 45, message = "name must be between 3 and 30 characters") String name,
			@NotEmpty(message = "number of albums is required!") @Min(0) @Max(100) int numOfAlbums,
			@NotEmpty(message = "genre is required!") @Size(min = 3, max = 45, message = "genre must be between 3 and 30 characters") String genre,
			Boolean stillTouring, User user) {
		this.name = name;
		this.numOfAlbums = numOfAlbums;
		this.genre = genre;
		this.stillTouring = stillTouring;
		this.user = user;
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
	public int getNumOfAlbums() {
		return numOfAlbums;
	}
	public void setNumOfAlbums(int numOfAlbums) {
		this.numOfAlbums = numOfAlbums;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Boolean getStillTouring() {
		return stillTouring;
	}
	public void setStillTouring(Boolean stillTouring) {
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
    
}
