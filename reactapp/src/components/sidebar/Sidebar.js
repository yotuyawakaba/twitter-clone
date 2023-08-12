import React from 'react'
import TwitterIcon from '@mui/icons-material/Twitter';
import SidebarOption from './SidebarOption';
import HomeIcon from '@mui/icons-material/Home';
import SearchIcon from '@mui/icons-material/Search';
import MailOutlineIcon from '@mui/icons-material/MailOutline';
import NotificationsNoneIcon from '@mui/icons-material/NotificationsNone';
import BookmarkBorderIcon from '@mui/icons-material/BookmarkBorder';
import ListAltIcon from '@mui/icons-material/ListAlt';
import PermIdentityIcon from '@mui/icons-material/PermIdentity';
import MoreHorizIcon from '@mui/icons-material/MoreHoriz';
import { Button } from '@mui/material';
import "./Sidebar.css";


function Sidebar() {
  return (
    <div className="sidebar">
        {/* iconicon */}
        <TwitterIcon className='sidebar_twitterIcon'/>

        {/* optiontest */}
        <SidebarOption text="Home" Icon={HomeIcon} />
        <SidebarOption text="Search Topic" Icon={SearchIcon}/>
        <SidebarOption text="Notifications" Icon={NotificationsNoneIcon}/>
        <SidebarOption text="Messages" Icon={MailOutlineIcon}/>
        <SidebarOption text="BookMarks" Icon={BookmarkBorderIcon}/>
        <SidebarOption text="Lists" Icon={ListAltIcon}/>
        <SidebarOption text="Profile" Icon={PermIdentityIcon}/>
        <SidebarOption text="More" Icon={MoreHorizIcon}/>

        {/* button */}
        <Button variant="outlined" className='sidebar_tweet' fullWidth>Tweet</Button>
    </div>
  )
}

export default Sidebar