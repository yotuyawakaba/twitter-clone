import React from 'react'
import { Search } from "@mui/icons-material";
import { TwitterTimelineEmbed, TwitterShareButton,TwitterTweetEmbed } from 'react-twitter-embed';
import "./Widgets.css"

function Widgets() {
  return (
    <div className="widgets">
        <div className="widgets_input">
            <Search className='widgets_searchIcon'/>
            <input placeholder="search keyword" type="text"/>
        </div>

        <div className="widgets_widgetContainer">
            <h2>What's happening?</h2>

            {/* ライブラリ追加 */}
            <TwitterTweetEmbed tweetId={"1659425422457847813"}/>
            <TwitterTimelineEmbed sourceType="profile" screenName="ELLEGARDEN_OFCL" options={{height: 400}} />
            <TwitterShareButton url={"https://twitter.com/ELLEGARDEN_OFCL"} options={{text: "#test"}} />

        </div>
    </div>
  )
}

export default Widgets