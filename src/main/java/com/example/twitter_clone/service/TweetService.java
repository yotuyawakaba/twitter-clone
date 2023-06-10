package com.example.twitter_clone.service;

import java.util.List;

import com.example.twitter_clone.entity.Tweet;

public interface TweetService {
	
	List<Tweet> findAll();
	
	void insert(Tweet tweet);

}
