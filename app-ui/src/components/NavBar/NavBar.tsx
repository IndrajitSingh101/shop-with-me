import "bootstrap/dist/css/bootstrap.min.css";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import FormControl from "react-bootstrap/FormControl";
import React ,{ FunctionComponent } from "react";
import { Link } from 'react-router-dom';


const NavBar:FunctionComponent=()=>{
    return(
     <>
      <Navbar bg="light" expand="lg">
        <Navbar.Brand href="#home">App-ui</Navbar.Brand>
        <Navbar.Toggle />
        <Navbar.Collapse>
          <Nav className="mr-auto">
            <Nav.Link href="#home"><Link to="/Home">Home</Link></Nav.Link>
            <Nav.Link href="#inventory"><Link to="/Inventory">Inventory</Link></Nav.Link>
          </Nav>
          <Form inline>
            <FormControl type="text" placeholder="search" className="mr-sm-2" />
            <Button variant="outline-primary">search</Button>
          </Form>
        </Navbar.Collapse>
      </Navbar>
    </> 
    );
}

export default NavBar;