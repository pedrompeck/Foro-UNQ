import React from 'react';
import NavBar from './navBar';

class Search extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
           publicacionesBuscadas: this.props.location.state.response,
           value: this.props.location.state.nombre
        }
     }

    componentWillReceiveProps() {
        this.setState({
            value: this.props.location.state.nombre,
            publicacionesBuscadas: this.props.location.state.response
        })
    }

    
    render() {
        return(
            <div className="container">
               <NavBar allProps={this.props}/>
               <div className="container">
                    {this.state.publicacionesBuscadas.length == 0 &&
                            <div className="">
                                <h1 className="text-center m-5">No se han encontrado resultados para tu búsqueda ("{this.state.value}")</h1>
                            </div>
                    }
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