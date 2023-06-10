package com.example.twitter_clone.repository;

import java.util.List;

import com.example.twitter_clone.entity.Tweet;

public interface TweetRepository {

	List<Tweet> findAll();

	void insert(Tweet tweet);

}
