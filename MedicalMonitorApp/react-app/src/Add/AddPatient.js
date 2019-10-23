import React, { Component } from 'react';
import NewPatient from '../images/newpacient.png'
import AppNav from '../AppNav'
import {Button} from 'reactstrap'

class AddPatient extends Component 
{
    constructor()
    {
        super();

        this.state = {
            Id: 0,
            Email: '',
            Password: '',
            Name: '',
            BirthDate: '', 
            Gender: '',
            Address: '',
            shouldUpdate: false
        };
        this.handleInputChanged = this.handleInputChanged.bind(this);
        this.addPatient = this.addPatient.bind(this);
    }

    async componentDidMount()
    {
        const {userId} = this.props.match.params;

        const response = await fetch(`/patients/${userId}`);
        if(response.ok)
        {
            const body = await response.json();
            this.setState({Id: body.userId});
            this.setState({Email: body.email});
            this.setState({Password: body.password});
            this.setState({Name: body.name});
            this.setState({BirthDate: body.birthDate});
            this.setState({Gender: body.gender});
            this.setState({Address: body.address});
            this.setState({shouldUpdate: true})
        }
     }

    handleInputChanged(event)
    {
        this.setState({[event.target.name]: event.target.value});
    }

    async addPatient(event)
    {
        event.preventDefault();

        if(this.state.shouldUpdate)
        {
            await fetch(`/patients/${this.state.Id}`, {
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
                    birthDate: this.state.BirthDate,
                    gender: this.state.Gender,
                    address: this.state.Address,
                    medicationPlan: null
                    })
                });
        }
        else
        {
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
        }
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
                    <div className="centered">
                        <label>Birth Date:</label>
                        <input type="text" 
                            value={this.state.BirthDate}
                            onChange={this.handleInputChanged}
                            name="BirthDate"/>
                    </div>
                    <div className="centered">
                        <label>Gender:</label>
                        <input type="text" 
                            value={this.state.Gender}
                            onChange={this.handleInputChanged}
                            name="Gender"/>
                    </div>
                    <div className="centered">
                        <label>Address:</label>
                        <input type="text" 
                            value={this.state.Address}
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