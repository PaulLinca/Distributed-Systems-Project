import React, { Component } from 'react';
import AppNav from './AppNav'
import DrugBanner from './images/drugsbanner.png'
import {Table} from 'reactstrap'
import {Button} from 'reactstrap'
class Drug extends Component
 {
    state = 
    { 
        isLoading : true,
        Drugs: []
    }        

    async componentDidMount()
    {
        const response = await fetch('/drugs/');
        const body = await response.json();
        this.setState({Drugs : body, isLoading : false})
    }

    async deleteDrug(drugId, index)
    {
        const response = await fetch("/drugs/" + drugId, { method: 'DELETE'});
        if(response.ok)
        {
            var drugs = this.state.Drugs;
            drugs.splice(index, 1);
            this.setState({Drugs: drugs});
        }
    }

    render()
    { 
        const {Drugs, isLoading} = this.state;

        if(isLoading)
        {
            return (<div><AppNav/><br/><center>Loading</center></div>)
        }

        return ( 
            <div>
                <AppNav/>
                <img src={DrugBanner} alt="Available drugs"/>
                <Table striped>
                <thead>
                    <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Amount</th>
                    </tr>
                </thead>
                <tbody>
                {
                    Drugs.map((drug, index) =>
                        <tr key={index}>
                            <th scope="row">{drug.drugId}</th>
                            <td>{drug.name}</td>
                            <td>{drug.amountInGrams} g</td>
                            <td><Button onClick={this.deleteDrug.bind(this, drug.drugId, index)} outline color="danger">Delete</Button></td>
                        </tr>)
                }
                </tbody>
                </Table>
            </div>
        );    }
}
 
export default Drug;