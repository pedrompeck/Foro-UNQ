import React from 'react';
import { Route } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import Materias from './materias';
import Home from './home';

class AppRouter extends React.Component {
    
    render() {
        return (
          <BrowserRouter>
                <Route exact path="/materias" component={Materias} />
          </BrowserRouter>
        )
    }

}

export default AppRouter