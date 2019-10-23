import React, { Component } from 'react';
import AppNav from './AppNav'
import CaregiverBanner from './images/caregiverbanner.png'
import {Table, Button} from 'reactstrap'
import {Link} from 'react-router-dom'
import './styles.css'

class Caregiver extends Component 
{
    state = 
    { 
        isLoading : true,
        Caregivers: []
    }    

    async componentDidMount()
    {
        const response = await fetch('/caregivers/');
        const body = await response.json();
        this.setState({Caregivers : body, isLoading : false})
    }

    async deleteCaregiver(userId, index)
    {
        const response = await fetch("/caregivers/" + userId, { method: 'DELETE'});
        if(response.ok)
        {
            var caregivers = this.state.Caregivers;
            caregivers.splice(index, 1);
            this.setState({Caregivers: caregivers});
        }
    }


    render() 
    {
        const {Caregivers, isLoading} = this.state;

        if(isLoading)
        {
            return (<div><AppNav/><br/><center>Loading</center></div>)
        }

        return ( 
            <div>
                <AppNav/>
                <img src={CaregiverBanner} alt="Available caregivers"/>
                <div 
                    className="divheight"
                    style={{
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'center',
                    }}>
                    <Button outline color="success" tag={Link} to="/caregiver">Add Caregiver</Button>
                </div>
                <Table striped>
                <thead>
                    <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th></th>
                    <th></th>
                    </tr>
                </thead>
                <tbody>
                {
                    Caregivers.map((caregiver, index) =>
                        <tr key={index}>
                            <th scope="row">{caregiver.userId}</th>
                            <td>{caregiver.name}</td>
                            <td>{caregiver.email}</td>
                            <td><Button outline color="warning" tag={Link} to={'/caregiver/' + caregiver.userId}>Edit</Button></td>
                            <td><Button onClick={this.deleteCaregiver.bind(this, caregiver.userId, index)} outline color="danger">Delete</Button></td>
                        </tr>)
                }
                </tbody>
                </Table>
            </div>
        );
    }
}
 
export default Caregiver;