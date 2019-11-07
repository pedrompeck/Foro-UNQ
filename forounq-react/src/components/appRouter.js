import React from 'react';
import { Route } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import Login from './login';
import Home from './home';

class AppRouter extends React.Component {
    
    render() {
        return (
          <BrowserRouter>
                <Route exact path="/materias" component={Home} />
                <Route exact path="/" component={Login} />
          </BrowserRouter>
        )
    }

}

export default AppRouter