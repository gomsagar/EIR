import { Injectable, Inject } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class DataService {

    constructor(private _http: Http) {
        //super();
        //var window: Window; 
    }

    getData() 
    {
       return this._http.get('http://localhost:8080/EirWeb2/eir/getEligibleProduct')
            .map((res:Response) => res.json());            
    }

    getCount() 
    {
       return this._http.get('http://localhost:8080/EirWeb2/eir/getResponseObject')
            .map((res:Response) => res.json());            
    }

    getUserFlag() 
    {
       return this._http.get('http://localhost:8080/EirWeb2/eir/getUserFlag')
            .map((res:Response) => res.json());            
    }

    getEarlierRequestData(userID)
    {
             return this._http.get('http://localhost:8080/EirWeb2/eir/getEarlierRequest?userID=' + userID)
            .map((res:Response) => res.json());
    }

     getRequestedHTMLReport(requestId,reportType,isPdf){
    return this._http.get('http://localhost:8080/EirWeb2/eir/getHTMLReport?requestId='+ requestId + '&reportType=' + reportType + '&isPdf=' + isPdf)
    .map((res:Response) => res.json());
    }
    
    getRequestedPDFReport(requestId,reportType,isPdf){
    return this._http.get('http://localhost:8080/EirWeb2/eir/getPDFReport?requestId='+ requestId + '&reportType=' + reportType + '&isPdf=' + isPdf)
  //  .map(res=>res.json());
    }
}