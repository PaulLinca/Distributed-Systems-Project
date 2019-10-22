import React, { Component } from 'react';
import AppNav from './AppNav'
import PatientsBanner from './images/patientsbanner.png'
import {Table, Button} from 'reactstrap'
import {Link} from 'react-router-dom'
import './styles.css'

class Patient extends Component
 {
    state = 
    { 
        isLoading : true,
        Patients: []
    }   
    
    async componentDidMount()
    {
        const response = await fetch('/patients/');
        const body = await response.json();
        this.setState({Patients : body, isLoading : false})
    }

    async deletePatient(userId, index)
    {
        const response = await fetch("/patients/" + userId, { method: 'DELETE'});
        if(response.ok)
        {
            var patients = this.state.Patients;
            patients.splice(index, 1);
            this.setState({Patients: patients});
        }
    }

    render()
     { 
        const {Patients, isLoading} = this.state;

        if(isLoading)
        {
            return (<div><AppNav/><br/><center>Loading</center></div>)
        }

        return ( 
            <div>
                <AppNav/>
                <img src={PatientsBanner} alt="All patients"/>
                <div 
                    className="divheight"
                    style={{
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'center',
                    }}>
                    <Button outline color="success" tag={Link} to="/patient">Add Patient</Button>
                </div>
                <Table striped>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Birth Date</th>
                        <th>Gender</th>
                        <th>Address</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                {
                    Patients.map((patient, index) =>
                        <tr key={index}>
                            <th scope="row">{patient.userId}</th>
                            <td>{patient.name}</td>
                            <td>{patient.email}</td>
                            <td>{patient.birthdate}</td>
                            <td>{patient.gender}</td>
                            <td>{patient.address}</td>
                            <td><Button outline color="warning">View</Button></td>
                            <td><Button onClick={this.deletePatient.bind(this, patient.userId, index)} outline color="danger">Delete</Button></td>
                        </tr>)
                }
                </tbody>
                </Table>
            </div>
        );
    }
}
 
export default Patient;