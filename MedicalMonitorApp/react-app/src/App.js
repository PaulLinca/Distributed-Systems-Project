import React, { Component } from 'react';
import Doctor from "./Doctor";
import Home from "./Home";
import Patient from './Patient'
import Caregiver from './Caregiver'
import Drug from './Drug'
import Plan from './Plan'
import { Route, BrowserRouter as Router, Switch } from 'react-router-dom';

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
                </Switch>
            </Router>
        );
    }
}
 
export default App;