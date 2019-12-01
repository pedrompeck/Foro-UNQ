import React from 'react';
import { materias, login } from '../api/api';
import {Link} from 'react-router-dom';

class Login extends React.Component {

    constructor() {
        super();
        this.state = {
           username: '',
           password: '',
           error: '',
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
        const {username,password} = this.state
        this.setState({error: ''})
        if (username && password){
            login({username,password})
            .then(() => this.props.history.push('/home')) 
            .catch(() => this.setState({error: "Usuario o Contraseña Incorrectos"}))
        }
        
    }

    setFieldUser (e) {
        this.setState({username: e.target.value})
    }

    setFieldPassword (e) {
        this.setState({password: e.target.value})
    }

    render() {
        return(
            <div style={{position:'absolute',top: 0,left: 0,width: '100%',height: '100%',backgroundColor:'#a72f4e'}}>
                <div className="container centerRow" style={{backgroundColor: '#a72f4e'}}>
                    <div className="row">
                        <div className="col-4 offset-4">
                            <div className="container text-center" style={{margin:'0.5em'}}>
                            <h1> FORO UNQ</h1>
                                <div style={{margin:'1.5em'}}>
                                <input
                                placeholder="Usuario"
                                type="text"
                                onChange={(e) => this.setFieldUser(e)}
                                />
                                </div>
                                <div style={{margin:'1.5em'}}>  
                                <input
                                placeholder="Contraseña"
                                type="password"
                                onChange={(e) => this.setFieldPassword(e)}
                                />
                                </div>
                                <div style={{margin:'1em'}}>
                                <button type="button" className="btn btn-primary btn-block text-center" onClick={this.goToHome}> Ingresar</button>
                                </div>
                                <div style={{margin:'1em'}}>
                                    <Link to="/register"><p>Olvidé contraseña</p></Link>
                                </div>
                                <div class="alert alert-danger" role="alert" style={{borderColor:'#a72f4e', backgroundColor:'#a72f4e'}}>
                                    {this.state.error &&
                                        <h4 style={{color:'white'}}>Usuario o Password Incorrecto</h4>
                                    }
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
