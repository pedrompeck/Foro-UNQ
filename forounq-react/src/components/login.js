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
        this.setFieldUser = this.setFieldUser.bind(this)
        this.setFieldPassword = this.setFieldPassword.bind(this)
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

    setFieldUser (e) {
        this.setState({[e.target.userName]: e.target.value})
    }

    setFieldPassword (e) {
        this.setState({[e.target.password]: e.target.value})
    }

    render() {
        return(
            <div style={{position:'absolute',top: 0,left: 0,width: '100%',height: '100%',backgroundColor:'#a72f4e'}}>
                <div className="container centerRow" style={{backgroundColor: '#a72f4e'}}>
                    <div className="row">
                        <div className="col-4 offset-4">
                            <div className="container text-center">
                            <h1> FORO UNQ</h1>
                                <div style={{margin:'1em'}}>
                                <input
                                placeholder="Usuario"
                                type="text"
                                onChange={(e)=>this.setFieldUser(e)}
                                />
                                </div>
                                <div style={{margin:'1em'}}>  
                                <input
                                placeholder="Contraseña"
                                type="password"
                                onChange={(e)=>this.setFieldPassword(e)}
                                />
                                </div>
                                <div style={{margin:'0.5em'}}>
                                <button type="button" className="btn btn-primary btn-block text-center" onClick={this.goToHome}> Ingresar</button>
                                </div>
                                <div style={{margin:'0.5em'}}>
                                    <Link to="/register"><p>Olvidé contraseña</p></Link>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>        
        );
    }
}

export default Login;
