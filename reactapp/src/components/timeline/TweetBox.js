import React, { useState } from 'react';
import { Avatar, Button } from '@mui/material';
import "./TweetBox.css";
import axios from 'axios';

function TweetBox() {
  const [postTweet, setPostTweet] = useState("");
  const [postImage, setPostImage] = useState("");
  const apiUrl = "http://localhost:8080/api/insert";

  const creatTweet = (e) => {

    e.preventDefault();

    if(postTweet !== "") {
      axios.post(apiUrl, {
        user_id: 1,
        text: postTweet,
        image: postImage
      },{
        headers: {
          'Content-Type': "application/json" //ここapplication/jsonにすること
        },
      })
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
    }
    setPostTweet("");
    setPostImage("");

  }

  return (
    <div className="tweetBox">
        <form>
            <div className="tweetBox_input">
              <Avatar />
              <input
              value={postTweet} 
              placeholder="What's happening?" 
              type="text"
              onChange={(e) => setPostTweet(e.target.value)}              
              ></input>
            </div>
            <input
              value={postImage}  
              className="tweetBox_imageInput" 
              placeholder="Please type in image's URL" 
              type="text"
              onChange={(e) => setPostImage(e.target.value)}
            ></input>
            <Button 
              className="tweetBox_tweetButton" 
              type="submit"
              onClick={creatTweet}
              >Tweet</Button>
        </form>
    </div>
  )
}

export default TweetBox