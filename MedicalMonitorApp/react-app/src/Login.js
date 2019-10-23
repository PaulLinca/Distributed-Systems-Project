import React, { Component } from 'react';
import AppNav from './AppNav'
import LoginBanner from './images/loginbanner.png'
import {Button} from 'reactstrap'
import {Link} from 'react-router-dom'

class Login extends Component
 {
    constructor()
    {
        super();

        this.state =  {
            Email: '',
            Password: '',
            Type: ''
        }
    }

    handleInputChanged(event)
    {
        this.setState({[event.target.name]: event.target.value});
    }

    render()
    { 
        return ( 
            <div>
                <AppNav/>
                <img src={LoginBanner} alt="Welcome! Please log in"/>
                <form>
                    <div className="centered">
                        <label>Email:</label>
                        <input type="text" 
                            onChange={this.handleInputChanged}
                            name="Email"/>
                    </div>
                    <div className="centered">
                        <label>Password:</label>
                        <input type="password" 
                            onChange={this.handleInputChanged}
                            name="Password"/>
                    </div >
                    <div className="centered">
                        <label>Login as a: </label>
                        <select>
                            <option value="doctor">Doctor</option>
                            <option selected value="patient">Patient</option>
                            <option value="caregiver">Caregiver</option>
                        </select>
                    </div>
                    <center><Button color="primary" tag={Link} to="/">Login</Button></center>
                </form>
            </div>
        );
    }
}
 
export default Login;