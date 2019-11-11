import React from 'react';
import { materias } from '../api/api';

class Login extends React.Component {

    constructor() {
        super();
        this.state = {
           userName: '',
           password: '',
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
                        <h1> FORO - UNQ </h1>
                            <div>
                              <p>Login</p>
                              <p>Olvide contraseña</p>
                             </div>
                    </div>
        );
    }
}

export default Login;