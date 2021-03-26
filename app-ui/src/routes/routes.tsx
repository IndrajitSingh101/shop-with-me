import React,{ FunctionComponent } from 'react';
import { Route, Switch, Redirect } from 'react-router-dom';
import NavBar from '../components/NavBar/NavBar';
import home from '../views/home/home'
import inventory from '../views/inventory/inventory'

const Routes:FunctionComponent=()=>{
   return( 
       <div>
        <NavBar></NavBar>
        <Switch>
            <Route exact path="/Home" component={home} />
            <Route exact path="/">
                <Redirect to="/Home" />
            </Route>
            <Route exact path="/Inventory" component={inventory} />
        </Switch>
       </div>
   );
}

export default Routes;