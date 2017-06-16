import { Injectable, Inject } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class DataService {

    constructor(private _http: Http) {}

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
}