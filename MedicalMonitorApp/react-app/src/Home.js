import React, { Component } from 'react';
import AppNav from './AppNav'
import Homebg from './images/home.png'
import {Button} from 'reactstrap'
import {Link} from 'react-router-dom'

class Home extends Component
 {
    state = {  }
    render() 
    { 
        return ( 
        <div>
            <AppNav/>
            <br/>
            <hr/>
            <center><img src={Homebg} alt="Welcome Page"/></center>
            <hr/>
            <center><font face="verdana" size="5" color="black">Get Started!</font></center>
            <center>
                <Button outline  color="primary" tag={Link} to='/login'>Login</Button>
            </center>
        </div>
        );
    }
}
 
export default Home;