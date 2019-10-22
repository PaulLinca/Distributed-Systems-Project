import React, { Component } from 'react';
import Doctor from "./Doctor";
import Home from "./Home";
import Patient from './Patient'
import Caregiver from './Caregiver'
import Drug from './Drug'
import Plan from './Plan'
import AddPatient from './AddPatient'
import { Route, BrowserRouter as Router, Switch } from 'react-router-dom';
import AddDrug from './AddDrug';
import AddCaregiver from './AddCaregiver';

class App extends Component 
{
    state = {  }
    render() { 
        return ( 
            <Router>
                <Switch>
                    <Route path='/' exact={true} component={Home}/>
                    <Route path='/doctors' exact={true} component={Doctor}/>
                    <Route path='/caregivers' exact={true} component={Caregiver}/>
                    <Route path='/patients' exact={true} component={Patient}/>
                    <Route path='/drugs' exact={true} component={Drug}/>
                    <Route path='/plans' exact={true} component={Plan}/>
                    <Route path='/patient' exact={true} component={AddPatient}/>
                    <Route path='/drug' exact={true} component={AddDrug}/>
                    <Route path='/caregiver' exact={true} component={AddCaregiver}/>
                </Switch>
            </Router>
        );
    }
}
 
export default App;