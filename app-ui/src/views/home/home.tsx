import React ,{ FunctionComponent } from "react";
import Grid from "../../components/grid/Grid";
import Container from 'react-bootstrap/Container';

const home:FunctionComponent=()=>{
    return  <Container fluid="sm">
                <Grid></Grid>
        </Container>
}

export default home;