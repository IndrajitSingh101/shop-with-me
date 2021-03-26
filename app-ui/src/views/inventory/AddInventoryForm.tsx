import React ,{ FunctionComponent,useState } from "react"
import { useForm } from "react-hook-form";
import "bootstrap/dist/css/bootstrap.min.css";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Container from 'react-bootstrap/Container';
import Toast from 'react-bootstrap/Toast';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import InventoryApi from "../../api/invetoryApi";
import {InventoryData} from "../../types/InventoryData";



const AddInventoryForm:FunctionComponent=()=>{
    const { register, handleSubmit, watch, errors }= useForm();
    const [show, setShow] = useState(false);
    const [ call, setCall] = useState(false);
    const onSubmit=handleSubmit((data:InventoryData)=>{
        InventoryApi.persistItem(data)
        .then(()=>{
            setShow(true);
            setCall(true);
        }).catch(()=>{
            setCall(false);
            setShow(true);
        })
    });

    return (
        <Container fluid="sm">
            <Row>
      <Col xs={6}>
        <Toast onClose={() => {
            setShow(false);
            setCall(false);
        }
            }  show={show} delay={3000} autohide>
          <Toast.Header>
            <strong className="mr-auto">Feedback</strong>
          </Toast.Header>
          <Toast.Body>Item save state: {call?'success':'failure'}</Toast.Body>
        </Toast>
      </Col>
    </Row>
        <Form onSubmit={onSubmit}>
            <Form.Group controlId="formCategory">
                <Form.Label>Category</Form.Label>
                <Form.Control ref={register} type="input" name="category" placeholder="Category" size="sm"></Form.Control>
            </Form.Group>
            <Form.Group controlId="formItemName">
                <Form.Label>Item Name</Form.Label>
                <Form.Control ref={register} type="input" name="itemName" placeholder="Item Name" size="sm"></Form.Control>
            </Form.Group>
            <Form.Group controlId="formItemDescription">
                <Form.Label>Item Description</Form.Label>
                <Form.Control ref={register} type="textarea" name="itemDescription" placeholder="Item Description" size="sm"></Form.Control>
            </Form.Group>
            <Form.Group controlId="formItemPrice">
                <Form.Label>Item Price</Form.Label>
                <Form.Control ref={register} type="input" defaultValue="0.0" name="price" placeholder="Item Price" size="sm"></Form.Control>
            </Form.Group>
            <Form.Group controlId="formItemQuantity">
                <Form.Label>Item Quantity</Form.Label>
                <Form.Control ref={register} type="input" defaultValue="0" name="itemQuantity" placeholder="Item Quantity" size="sm"></Form.Control>
            </Form.Group>
            <Form.Group controlId="formCompanyAddress">
                <Form.Label>Company Address</Form.Label>
                <Form.Control ref={register} type="textarea" name="address" placeholder="Company Address" size="sm"></Form.Control>
            </Form.Group>
            <Form.Group controlId="formManufacturingCompany">
                <Form.Label>Manufacturing Company Name</Form.Label>
                <Form.Control ref={register} type="input" name="manufacturingCompany" placeholder="Manufacturing company name" size="sm"></Form.Control>
            </Form.Group>
            <Form.Group controlId="formVendorName">
                <Form.Label>Vendor Name</Form.Label>
                <Form.Control ref={register} type="input" name="vendorName" placeholder="Vendor Name" size="sm" ></Form.Control>
            </Form.Group>
            <Button variant="primary" type="submit">
                Submit
            </Button>

        </Form>
        </Container>

    );
}

export default AddInventoryForm;