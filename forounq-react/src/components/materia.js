import React from 'react';
import { materia } from '../api/api';
import NavBar from './navBar';

class Materia extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            materia: {
                id: '',
                name: '',
                descripcion: '',
                nombresDePublicaciones: []
            }
        }
    }

    componentDidMount() {
        materia(this.props.location.state.idMateria).then(response => {
            this.setState({
                materia: response
            })
        })
        .catch(error => {
            console.log(error);
        })
    }

    render() {
        return (            
            <div className="container">
                <NavBar allProps={this.props}/>  
                <h1> Materia: {this.state.materia.name} </h1>
                <div>
                    <p>Descripcion: {this.state.materia.descripcion}</p>
                    <p>Publicaciones: 
                                  <ul>{this.state.materia.nombresDePublicaciones.map(nombre => 
                                        <li>{nombre}</li>
                                    )}
                                  </ul>
                    </p>
                </div>
            </div> 
        );
    }
}

export default Materia;