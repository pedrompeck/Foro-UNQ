import React from 'react';
import { materias } from '../api/api';
import Materias from './materias';
import NavBar from './navBar';

class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
           materias: []
        }
    }

    componentDidMount() {
        materias()
        .then(response => {
          console.log(response);
          this.setState({
                materias: response
            })  
        })
        .catch(error => {
            console.log(error);
        })
    }
   
    render() {
        return(
            <div className="container">
              <NavBar />  
              <Materias />     
            </div>
        );
    }
}

export default Home     ;