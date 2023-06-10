import React, { useEffect, useState } from 'react'
import TweetBox from './TweetBox'
import "./Timeline.css"
import Post from './Post'
import axios from 'axios';
import FlipMove from "react-flip-move";

function Timeline() {
  const [tweetList, setTweetList] = useState([]);
  const apiUrl = "http://localhost:8080/api/";
  
  useEffect(() => {
    const getTweet = () => {
      axios.get(apiUrl + 'list')
      .then(res => {
      setTweetList(res.data);
      })
    }
    getTweet();
  }, [tweetList]);

  return (
    <div className="timeline">
        {/* header */}
        <div className="timeline_header">
            <h2>Home</h2>
        </div>

        {/* tweetbox */}
        <TweetBox />

        {/* post */}
        <FlipMove>
        {tweetList.map((tweetInfo) => {
        return(
          <Post 
            key={tweetInfo.id}
            displayname={tweetInfo.user.displayname}
            username={tweetInfo.user.username}
            text={tweetInfo.text}
            avatar={tweetInfo.user.abatar}
            image={tweetInfo.image}
          />
        );
      })}
        </FlipMove>
    </div>
  )
}

export default Timeline