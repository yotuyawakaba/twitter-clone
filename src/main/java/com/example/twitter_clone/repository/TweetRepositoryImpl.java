package com.example.twitter_clone.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.twitter_clone.entity.Tweet;
import com.example.twitter_clone.entity.User;

@Repository
public class TweetRepositoryImpl implements TweetRepository {

	private final JdbcTemplate jdbcTemplate;

	public TweetRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Tweet> findAll() {
		String sql = "select tweet.id, tweet.user_id, tweet.text, tweet.image, tweet.timestamp, public.user.displayname, public.user.username, public.user.abatar, public.user.address, public.user.password from public.tweet inner join public.user on public.user.id = public.tweet.user_id where user_id = 1 order by public.tweet.id desc";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Tweet> list = new ArrayList<Tweet>();
		
		for (Map<String, Object> result : resultList) {
			Tweet tweet = new Tweet();
			tweet.setId((int)result.get("id"));
			tweet.setUser_id((int)result.get("user_id"));
			tweet.setText((String)result.get("text"));
			tweet.setImage((String)result.get("image"));
			tweet.setTimestamp(((Timestamp) result.get("timestamp")).toLocalDateTime());
			
			User user = new User();
			user.setDisplayname((String)result.get("displayname"));
			user.setUsername((String)result.get("username"));
			user.setAbatar((String)result.get("abatar"));
			user.setAddress((String)result.get("address"));
			user.setPassword((String)result.get("password"));
			tweet.setUser(user);
			
			list.add(tweet);
		}

		return list;
	}

	@Override
	public void insert(Tweet tweet) {
		
		jdbcTemplate.update("insert into public.tweet (user_id, text, image, timestamp) values (?, ?, ?, ?);", 
				tweet.getUser_id(), tweet.getText(), tweet.getImage(), tweet.getTimestamp());

	}

}
