import React from 'react';
import { materias } from '../api/api';
import {Link} from 'react-router-dom';

class Login extends React.Component {

    constructor() {
        super();
        this.state = {
           userName: '',
           password: '',
        }
        this.goToHome = this.goToHome.bind(this)
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
 
    goToHome() {
        this.props.history.push('/home')
    }

    render() {
        return(
            <div className="container centerRow">
                <div className="row">
                    <div className="col-4 offset-4">
                        <div className="container text-center">
                        <h1> FORO UNQ</h1>
                            <div>
                              <p>Login</p>
                              <button type="button" className="btn btn-primary btn-block text-center" onClick={this.goToHome}> Ingresar</button>
                              <Link to="/register"><p>Olvidé contraseña</p></Link>
                             </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Login;
