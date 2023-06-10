package com.example.twitter_clone.app.tweet;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.twitter_clone.entity.Tweet;
import com.example.twitter_clone.service.TweetService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TweetController {

	private final TweetService tweetService;

	public TweetController(TweetService tweetService) {
		this.tweetService = tweetService;
	}

	// Return TweetList
	@RequestMapping("/list")
	@ResponseBody
	public List<Tweet> getTweet(Model model) {
		
		List<Tweet> list = tweetService.findAll();

		return list;

	}
	
	//Insert Tweet
	@PostMapping("/insert")
	public void insert (@RequestBody InsertTweet insertTweet, BindingResult result, Model model) {
		
		Tweet tweet = makeTweet(insertTweet);
		
		tweetService.insert(tweet);
		
	}
	
	/**
     * InsertTweetのデータをtweetに入れて返す
     * @param insertTweet
     * @return tweet
     */
	public Tweet makeTweet(InsertTweet insertTweet) {
		Tweet tweet = new Tweet();
		
		tweet.setUser_id(insertTweet.getUser_id());
		tweet.setText(insertTweet.getText());
		tweet.setImage(insertTweet.getImage());
		tweet.setTimestamp(LocalDateTime.now());
		
		return tweet;
	}

}
