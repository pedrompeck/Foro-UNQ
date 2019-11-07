import React from 'react';
import { publicaciones , materias } from '../api/api';
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
    UncontrolledDropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem } from 'reactstrap';
import { Icon, Button, Input } from 'semantic-ui-react';
import { Link } from 'react-router-dom';


class NavBar extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
          valor: '',
        }
        this.handleChange = this.handleChange.bind(this);
        this.search = this.search.bind(this);
    }
     
    handleChange(e) {
        this.setState({ valor: e.target.value });
    }

    search() {
        publicaciones(this.state.valor)
        .then(response =>  this.props.allProps.history.push( {
                                                            pathname:'/search/',
                                                            search: '?q=' + this.state.valor, 
                                                            state: response 
        }))
        .catch(error => console.log(error))
    }
  
    render() {
            return (
              <div>
                  <Navbar color="light" light expand="md">
                    <NavbarBrand href="/home">Foro-UNQ</NavbarBrand>
                    <NavbarToggler onClick={this.toggle} />
                    <Collapse isOpen={true} navbar>
                    <Input type='text' placeholder='Buscar...' action onChange={this.handleChange}/>
                    <Button type='submit' color='red' onClick={this.search}>Buscar</Button>
                  </Collapse>
                  </Navbar>
                </div>
              );
        }
}

export default NavBar;
















