import React from 'react';
import { materias } from '../api/api';

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
                            {this.state.materias.map(materia => 
                            <div>
                              <p>Materia: {materia.name}</p>
                              <p>Descripcion: {materia.descripcion}</p>
                             </div> 
                            )}
                    </div>
        );
    }
}

export default Materias;