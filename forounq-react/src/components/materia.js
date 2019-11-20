import React from 'react';
import { materia } from '../api/api';

class Materia extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            materia: {
                id: '',
                name: '',
                descripcion: '',
                publicaciones: []
            }
        }
    }

    componentDidMount() {
        materia().then(response => {
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
                <h1> Materia: {this.state.materia.name} </h1>
                <div>
                    <p>Descripcion: {this.state.materia.descripcion}</p>
                    <p>Publicaciones:
                        <ul>
                            {this.state.materia.publicaciones.map(publicacion =>
                                <li>{publicacion.comentarios}</li>
                            )}
                        </ul>
                    </p>
                </div>
            </div>
        );
    }
}

export default Materia;