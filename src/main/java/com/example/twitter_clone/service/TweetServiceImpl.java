package com.example.twitter_clone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.twitter_clone.entity.Tweet;
import com.example.twitter_clone.repository.TweetRepository;

@Service
public class TweetServiceImpl implements TweetService {
	
	private final TweetRepository repository;
	
	public TweetServiceImpl(TweetRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Tweet> findAll() {
		
		return repository.findAll();
	}

	@Override
	public void insert(Tweet tweet) {
		repository.insert(tweet);
	}

}
