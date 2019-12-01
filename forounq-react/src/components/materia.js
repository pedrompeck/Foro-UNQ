import React from 'react';
import { materia } from '../api/api';
import NavBar from './navBar';
import {
    Form,
    FormGroup,
    Input,
    Button } from 'reactstrap';

class Materia extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            id: '',
            name: '',
            descripcion: '',
            nombresDePublicaciones: [],
            comentarios: [],
            comentario: '',
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount() {
        materia(this.props.location.state.idMateria).then(response => {
            this.setState({
                id: response.id,
                name: response.name,
                descripcion: response.descripcion,
                nombresDePublicaciones: response.nombresDePublicaciones,
                comentarios: response.comentarios
            })
        })
        .catch(error => {
            console.log(error);
        })
    }

    handleChange(e) {
        this.setState({ comentario: e.target.value });
    }

    handleSubmit(e) {
        if(this.state.comentario) {
            this.state.comentarios[0].push({ id: 20, mensaje: this.state.comentario })
        }

        this.setState( { comentarios: this.state.comentarios })
        this.setState( { comentario: ''})

        e.preventDefault();
    }

    comentariosDePublicacion(i) {
       let comentarios = this.state.comentarios[i];
        return ( 
            <div className="container">
                 {comentarios.map(comentario => <p> {comentario.mensaje} </p>)} 
            </div>
        )
    }

    render() {
        return (            
            <div className="container">
                <NavBar allProps={this.props}/>  
                <h1> Materia: {this.state.name} </h1>
                <div>
                    <p>Descripcion: {this.state.descripcion}</p>
                    <p>{this.state.nombresDePublicaciones.map((nombre, index) => 
                        <div>
                             <h3> {nombre} </h3>
                             {this.comentariosDePublicacion(index)}
                             <Form onSubmit={this.handleSubmit}>
                                <FormGroup>
                                    <Input type="textarea" name="text" id="exampleText" onChange={this.handleChange} />
                                    <br />
                                    <Button color="primary" type="submit"> Enviar comentario </Button>
                                </FormGroup>
                             </Form>
                        </div>
                    )}
                    </p>
                
                </div>
            </div> 
        );
    }
}

export default Materia;
