import { Injectable, Inject } from '@angular/core';
import {Http, Headers} from "@angular/http";
import 'rxjs/add/operator/map';
@Injectable()

export class CompanyNameService {

    constructor(private _http:Http) {

    }

    validateName(cmpName) {
        console.log('Company Name ------------------------------------ '+cmpName);
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');
         
        return this._http.post('http://localhost:8080/EirWeb2/eir/getCompanyList',
        JSON.stringify(cmpName), { 
          headers:headr
        })
        .map(res=>res.json());
    }
}