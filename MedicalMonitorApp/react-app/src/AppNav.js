import React, { Component } from 'react';
import {Nav, Navbar, NavItem, NavbarBrand, NavLink } from 'reactstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import Logo from './images/logotext.png'
class AppNav extends Component 
{
    state = {  }
    render() 
    { 
        return (
          <div>
            <Navbar color="dark" dark expand="md">
              <NavbarBrand href="/"><img src={Logo} mode='fit' alt="Medical Monitor"/></NavbarBrand>
              <Nav className="ml-auto" navbar>
                <NavItem>
                  <NavLink href="/">Home</NavLink>
                </NavItem>
                <NavItem>
                  <NavLink href="/doctors/">Doctors</NavLink>
                </NavItem>
                <NavItem>
                  <NavLink href="/drugs/">Medication</NavLink>
                </NavItem>
                <NavItem>
                  <NavLink href="/caregivers/">Caregivers</NavLink>
                </NavItem>
                <NavItem>
                  <NavLink href="/patients/">Patients</NavLink>
                </NavItem>
              </Nav>
            </Navbar>
          </div>
        );
    }
}

export default AppNav;