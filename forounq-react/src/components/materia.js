import React from 'react';

class Materia extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
           materia: ""
        }
    }

    render() {
        return(
            <div className="container">
                        <h1> Materia: {materia.name} </h1>
                            {this.state.materias.map(materia => 
                            <div>
                              <p>Descripcion: {materia.descripcion}</p>
                              <p>Publicaciones: 
                                  <ul>
                                      {materia.nombresDePublicaciones.map(nombre => 
                                        <li>{nombre}</li>
                                    )}
                                  </ul>
                              </p>
                             </div> 
                            )}
                    </div>
        );
    }
}

export default Materia;