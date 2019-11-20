import React from 'react';
import { materias } from '../api/api';
import { Link } from 'react-router-dom';


class Materias extends React.Component {

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
                <h1> Materias </h1>
                    {this.state.materias.map(
                        function(materia, i){
                            return  <p> Materia:  <Link to={{ pathname: `/materias/${materia.id}`, state: { idMateria: materia.id}}}> {materia.name}  </Link> </p>
                        }
                        /*
                        materia => 
                        <p> Materia:  <Link to={ `/materia/${materia.id}`}> {materia.name}  </Link> </p>
                        */
                    )}
                <h1> Mis Favoritos </h1>    
            </div>
        );
    }
}

export default Materias;