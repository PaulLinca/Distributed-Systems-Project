import React, { Component } from 'react';
import NewPatient from './images/newpacient.png'
import AppNav from './AppNav'
import {Button} from 'reactstrap'

class AddPatient extends Component 
{
    constructor()
    {
        super();

        this.state = {  
            Email: '',
            Password: '',
            Name: '',
            BirthDate: '', 
            Gener: '',
            Address: ''
        };
        this.handleInputChanged = this.handleInputChanged.bind(this);
        this.addPatient = this.addPatient.bind(this);
    }


    handleInputChanged(event)
    {
        this.setState({[event.target.name]: event.target.value});
    }

    async addPatient(event)
    {
        event.preventDefault();
        await fetch('/patients/', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
              },
            body: JSON.stringify({
                email: this.state.Email,
                password: this.state.Password,
                name: this.state.Name,
                birthDate: this.state.BirthDate,
                gender: this.state.Gender,
                address: this.state.Address,
                medicationPlan: null
                })
            });
        this.props.history.push('/patients')
    }

    render() 
    { 
        return ( 
            <div>
                <AppNav/>
                <img src={NewPatient} alt="Add Patient"/>
                <br/>
                <form onSubmit={this.addPatient}>
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
                    <div className="centered">
                        <label>Birth Date:</label>
                        <input type="text" 
                            onChange={this.handleInputChanged}
                            name="BirthDate"/>
                    </div>
                    <div className="centered">
                        <label>Gender:</label>
                        <input type="text" 
                            onChange={this.handleInputChanged}
                            name="Gender"/>
                    </div>
                    <div className="centered">
                        <label>Address:</label>
                        <input type="text" 
                            onChange={this.handleInputChanged}
                            name="Address"/>
                    </div>
                    <center><Button type="submit">Add Patient</Button></center>
                </form>
            </div>
         );
    }
}
 
export default AddPatient;