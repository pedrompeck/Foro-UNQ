import React from 'react';
import NavBar from './navBar';

class Search extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
           publicacionesBuscadas: this.props.location.state
        }
     }

    componentWillReceiveProps() {
        const ubicacion = this.props.location.state
        this.setState({
            publicacionesBuscadas: ubicacion
        })
    }

    
    render() {
        return(
            <div className="container">
               <NavBar allProps={this.props}/>
               <div className="container">
                    {this.state.publicacionesBuscadas.map(publicacion => 
                    <div>
                        <p>Nombre: {publicacion.name} </p>
                        <p>Descripción: {publicacion.descripcion}</p>        
                        <p>Comentarios: 
                            <ul>
                                {publicacion.comentarios.map(comentario => 
                                    <li>{comentario.mensaje}</li>
                                )}
                            </ul>
                        </p>
                    </div>
                    )}
                </div>
            </div>
        )
    }
}

export default Search;