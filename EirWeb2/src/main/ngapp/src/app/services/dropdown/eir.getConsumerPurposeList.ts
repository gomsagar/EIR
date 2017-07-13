import { Injectable, Inject } from '@angular/core';
import {Http, Headers} from "@angular/http";
import 'rxjs/add/operator/map';
import { APP_CONFIG, IAppConfig } from '../../app.config';

@Injectable()
export class ConsumerPurposeList {
    
    public serviceUrl : string;
    constructor(private _http:Http , @Inject(APP_CONFIG) private config: IAppConfig) {
        this.serviceUrl = this.config.apiEndpointForLocalHost;
    }
    
    getConsumerPurposeList() {
        console.log('Cir purpose Name ------------------------------------ ');
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');
         
        return this._http.get(this.serviceUrl+ 'getConsumerPurposeList').map(res=>res.json());
    }

    getConsumerFinancialPurposeList(purposeId) {
        console.log('Cir purpose Name ------------------------------------ ');
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');
         
        return this._http.get(this.serviceUrl+ 'getConsumerFinancialPurposeList?purposeId=' + purposeId).map(res=>res.json());
    }

    getGender() {
        console.log("this.serviceUrl:::::::::::"+this.serviceUrl);
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');
        return this._http.get(this.serviceUrl+'getGender').map(res=>res.json());
    }
    getFrequency() {
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');
        return this._http.get(this.serviceUrl+ 'getFrequency').map(res=>res.json());
        
    }

}