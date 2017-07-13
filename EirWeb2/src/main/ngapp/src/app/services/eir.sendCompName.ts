import { Injectable, Inject } from '@angular/core';
import {Http, Headers} from "@angular/http";
import 'rxjs/add/operator/map';
import { APP_CONFIG, IAppConfig } from '../app.config';

@Injectable()

export class CompanyNameService {
    userId:Number;
    public serviceUrl : string;
    constructor(private _http:Http, @Inject(APP_CONFIG) private config: IAppConfig) {
        this.userId=1;
        this.serviceUrl = this.config.apiEndpointForLocalHost;
    }

    validateName(cmpName) {
        console.log('Company Name ------------------------------------ '+cmpName);
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');
         
        return this._http.post(this.serviceUrl+ 'getCompanyList',
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

        return this._http.post(this.serviceUrl+ 'getDashboardObject?userId=' + userId , 
        JSON.stringify(userId), { headers:headr}).map(res=>res.json());
    }
}