import React, { Component } from 'react';
import AppNav from './AppNav'
import DoctorsBanner from './images/doctorsbanner.png'
import {Table} from 'reactstrap'

class Doctor extends Component 
{
    state = 
    { 
        isLoading : true,
        Doctors: []
    }

    async componentDidMount()
    {
        const response = await fetch('/doctors/');
        const body = await response.json();
        this.setState({Doctors : body, isLoading : false})
    }

    render() 
    { 
        const {Doctors, isLoading} = this.state;

        if(isLoading)
        {
            return (<div><AppNav/><br/><center>Loading</center></div>)
        }
    
        return ( 
            <div>
                <AppNav/>
                <img src={DoctorsBanner} alt="All our doctors"/>
                <Table striped>
                <thead>
                    <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Medical Field</th>
                    </tr>
                </thead>
                <tbody>
                {
                    Doctors.map(doctor =>
                        <tr>
                            <th scope="row">{doctor.userId}</th>
                            <td>Dr. {doctor.name}</td>
                            <td>{doctor.email}</td>
                            <td>{doctor.medicalField}</td>
                        </tr>)
                }
                </tbody>
                </Table>
            </div>
        );
    }
}
 
export default Doctor;