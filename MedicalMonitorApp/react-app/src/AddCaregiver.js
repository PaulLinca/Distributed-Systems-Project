import React, { Component } from 'react';
import AppNav from './AppNav'
import {Button} from 'reactstrap'
import NewCaregiver from './images/newcaregiver.png'

class AddCaregiver extends Component 
{
    constructor()
    {
        super();

        this.state = {  
            Email: '',
            Password: '',
            Name: ''
        };
        this.handleInputChanged = this.handleInputChanged.bind(this);
        this.addCaregiver = this.addCaregiver.bind(this);
    }

    handleInputChanged(event)
    {
        this.setState({[event.target.name]: event.target.value});
    }

    async addCaregiver(event)
    {
        event.preventDefault();
        const response = await fetch('/caregivers/', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
              },
            body: JSON.stringify({
                email: this.state.Email,
                password: this.state.Password,
                name: this.state.Name,
                patients: null
            })
        });
        alert(response.status)
        this.props.history.push('/caregivers')
    }

    render() 
    { 
        return ( 
            <div>
                <AppNav/>
                <img src={NewCaregiver} alt="Add Caregiver"/>
                <br/>
                <form onSubmit={this.addCaregiver}>
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
                    </div>
                    <div className="centered">
                        <label>Name:</label>
                        <input type="text" 
                            onChange={this.handleInputChanged}
                            name="Name"/>
                    </div>
                    <center><Button type="submit">Add Caregiver</Button></center>
                </form>
            </div>
         );
    }
}

export default AddCaregiver;