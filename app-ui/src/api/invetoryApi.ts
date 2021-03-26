import axios from "axios";
import {InventoryData} from "../types/InventoryData";
const http=axios.create({
    baseURL:"http://localhost:8080/inventory",
    headers: {
        "Content-type": "application/json"
      }
});

const persistItem=(data:InventoryData)=>{
    return http.post("/publishItem",data);
}

const getAll=()=>{
    return http.get("/itemList");
}

export default {
    getAll,
    persistItem
}