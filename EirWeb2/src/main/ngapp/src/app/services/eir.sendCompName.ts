import { Injectable, Inject } from '@angular/core';
import {Http, Headers} from "@angular/http";
import 'rxjs/add/operator/map';
@Injectable()

export class CompanyNameService {
userId:Number;
    constructor(private _http:Http) {
this.userId=1;
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

    getCount(userId) 
    {
         console.log('userId ------------------------------------ '+userId);
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');

        return this._http.post('http://localhost:8080/EirWeb2/eir/getDashboardObject?userId=' + userId , 
        JSON.stringify(userId), { headers:headr}).map(res=>res.json());
    }
}