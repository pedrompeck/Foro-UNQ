import React from 'react';
import { Route } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import Login from './login';
import Home from './home';
import Search from './search';
import Register from './register'

class AppRouter extends React.Component {
    
    render() {
        return (
          <BrowserRouter>
                <Route exact path="/home" component={Home} />
                <Route exact path="/search" component={Search} />
                <Route exact path="/" component={Login} />
                <Route exact path="/register" component={Register} />      
                
          </BrowserRouter>
        )
    }

}

export default AppRouter