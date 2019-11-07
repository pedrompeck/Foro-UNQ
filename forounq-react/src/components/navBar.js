import React from 'react';

export default class NavBarPrincipal extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
          valor: '',
        }
      }

    render() {
        return( 
        <div>
            <nav class="navbar navbar-light bg-light">
                <a class="navbar-brand">ForoUNQ</a>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"/>
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </nav>
        </div>
)}
}

















