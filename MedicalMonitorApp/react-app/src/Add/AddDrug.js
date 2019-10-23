import React, { Component } from 'react';
import NewDrug from '../images/newdrug.png'
import AppNav from '../AppNav'
import {Button} from 'reactstrap'

class AddDrug extends Component
{
    constructor()
    {
        super();

        this.state = {  
            Id: 0,
            Name: ' ',
            Amount: 0,
            shouldUpdate: false
        };
        this.handleInputChanged = this.handleInputChanged.bind(this);
        this.addDrug = this.addDrug.bind(this);
    }

    async componentDidMount()
    {
        const {drugId} = this.props.match.params;

        const response = await fetch(`/drugs/${drugId}`);
        if(response.ok)
        {
            const body = await response.json();
            this.setState({Id: body.drugId});
            this.setState({Amount: body.amountInGrams});
            this.setState({Name: body.name});
            this.setState({shouldUpdate: true})
        }
     }

    handleInputChanged(event)
    {
        this.setState({[event.target.name]: event.target.value});
    }

    async addDrug(event)
    {
        event.preventDefault();

        if(this.state.shouldUpdate)
        {
            await fetch(`/drugs/${this.state.Id}`, {
                method: 'PUT',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                  },
                body: JSON.stringify({
                    drugId: this.state.Id,
                    name: this.state.Name,
                    amountInGrams: this.state.Amount,
                    prescriptions: null
                    })
                });
        }
        else
        {
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
        }

        this.props.history.push('/drugs')
    }

    render() 
    { 
        return ( 
            <div>
                <AppNav/>
                <img src={NewDrug} alt="Add Drug"/>
                <br/>
                <form onSubmit={this.addDrug}>
                    <div className="centered">
                        <label>Name:</label>
                        <input type="text" 
                            value={this.state.Name}
                            onChange={this.handleInputChanged}
                            name="Name"/>
                    </div>
                    <div className="centered">
                        <label>Amount (g):</label>
                        <input type="number" 
                            value={this.state.Amount}
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