import React, { Component } from 'react';
import AppNav from '../AppNav'
import {Button} from 'reactstrap'
import NewCaregiver from '../images/newcaregiver.png'

class AddCaregiver extends Component 
{
    constructor()
    {
        super();

        this.state = {  
            Id: 0,
            Email: '',
            Password: '',
            Name: '',
            shouldUpdate: false
        };
        this.handleInputChanged = this.handleInputChanged.bind(this);
        this.addCaregiver = this.addCaregiver.bind(this);
    }

    async componentDidMount()
    {
        const {userId} = this.props.match.params;

        const response = await fetch(`/caregivers/${userId}`);
        if(response.ok)
        {
            const body = await response.json();
            this.setState({Id: body.userId});
            this.setState({Email: body.email});
            this.setState({Password: body.password});
            this.setState({Name: body.name});
            this.setState({shouldUpdate: true})
        }
     }

    handleInputChanged(event)
    {
        this.setState({[event.target.name]: event.target.value});
    }

    async addCaregiver(event)
    {
        event.preventDefault();
        
        if(this.state.shouldUpdate)
        {
            await fetch(`/caregivers/${this.state.Id}`, {
                method: 'PUT',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                  },
                body: JSON.stringify({
                    userId: this.state.Id,
                    email: this.state.Email,
                    password: this.state.Password,
                    name: this.state.Name,
                    patients: null
                })
            });
        }
        else
        {
            await fetch('/caregivers/', {
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
        }
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
                            value={this.state.Email}
                            onChange={this.handleInputChanged}
                            name="Email"/>
                    </div>
                    <div className="centered">
                        <label>Password:</label>
                        <input type="password" 
                            value={this.state.Password}
                            onChange={this.handleInputChanged}
                            name="Password"/>
                    </div>
                    <div className="centered">
                        <label>Name:</label>
                        <input type="text" 
                            value={this.state.Name}
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