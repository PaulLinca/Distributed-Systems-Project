import React, { Component } from 'react';
import NewPatient from './images/newdrug.png'
import AppNav from './AppNav'
import {Button} from 'reactstrap'

class AddDrug extends Component
{
    constructor()
    {
        super();

        this.state = {  
            Name: ' ',
            Amount: 0
        };
        this.handleInputChanged = this.handleInputChanged.bind(this);
        this.addDrug = this.addDrug.bind(this);
    }

    handleInputChanged(event)
    {
        this.setState({[event.target.name]: event.target.value});
    }

    async addDrug(event)
    {
        event.preventDefault();
        await fetch('/drugs/', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
              },
            body: JSON.stringify({
                name: this.state.Name,
                amountInGrams: this.state.Amount,
                prescriptions: null
                })
            });
        this.props.history.push('/drugs')
    }

    render() 
    { 
        return ( 
            <div>
                <AppNav/>
                <img src={NewPatient} alt="Add Drug"/>
                <br/>
                <form onSubmit={this.addDrug}>
                    <div className="centered">
                        <label>Name:</label>
                        <input type="text" 
                            onChange={this.handleInputChanged}
                            name="Name"/>
                    </div>
                    <div className="centered">
                        <label>Amount (g):</label>
                        <input type="number" 
                            onChange={this.handleInputChanged}
                            name="Amount"/>
                    </div>
                    <center><Button type="submit">Add Drug</Button></center>
                </form>
            </div>
         );
    }
}
 
export default AddDrug;