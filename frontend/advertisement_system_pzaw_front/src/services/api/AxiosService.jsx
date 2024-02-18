import axios from "axios";

function errorHandler(response){
    if(!response)return;
    let httpResponse = {
        "status" : response.status
    }
    try{
        if(response.status == 400){
        httpResponse = {...httpResponse, isSuccesfull : false, violations : response.data.violations };
        }
        else if(response.status == 401 || response.status == 412 || response.status == 404){
        httpResponse = {...httpResponse, isSuccesfull : false, message: response.data.message};
        }
        else {
        httpResponse = {...httpResponse, isSuccesfull : false, message: "An unexpected error occured"};
        }
        return httpResponse;
    }
    catch(error){
        return {...httpResponse, isSuccesfull : false, message: "An unexpected error occured"};
    }
    
}
    
export function request({method, url, headers, data}){
    return axios({
        method : method,
        url : url,
        headers : headers,
        data : data
        })
    .then((res)=>{
        res = {status : res.status , isSuccesfull : true, data : res.data};
        return res; 
    })
    .catch((error)=>{
        let res = errorHandler(error.response);
        return res; 
    });
}