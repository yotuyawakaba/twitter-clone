package com.example.twitter_clone.app.tweet;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class InsertTweet {

	public InsertTweet() {

	}
	
	private int id;
	
	private int user_id;
	
	private String text;
	
	private String image;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime timestamp;

	public InsertTweet(int id, int user_id, String text, String image, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.text = text;
		this.image = image;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	

}
