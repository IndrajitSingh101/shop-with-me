import React, { useState,useEffect } from 'react';
import { AgGridColumn, AgGridReact } from 'ag-grid-react';
import InventoryApi from "../../api/invetoryApi";
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';

const Grid = () => {
    const [rowData, setRowData] = useState([]);
    useEffect(()=>{
        InventoryApi.getAll()
        .then((result)=>{
            console.log(result.data);
            setRowData(result.data);
        })
        .catch((err)=>console.log(err));
    },[]);

    return (
        <div className="ag-theme-alpine" style={ { height: 400, width: 1000 } }>
            <AgGridReact
                rowData={rowData}>
                <AgGridColumn field="category" sortable={true} filter={true}></AgGridColumn>
                <AgGridColumn field="itemDetails.itemName" headerName="Item name" sortable={true} filter={true}></AgGridColumn>
                <AgGridColumn field="manufactureDetails.manufacturingCompany" headerName="Company" sortable={true} filter={true}></AgGridColumn>
                <AgGridColumn field="availableQuantity" sortable={true} filter={true}></AgGridColumn>
                <AgGridColumn field="itemDetails.price" headerName="price" sortable={true} filter={true}></AgGridColumn>
            </AgGridReact>
        </div>
    );
};

export default Grid;