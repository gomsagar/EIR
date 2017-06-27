import { Injectable, Inject } from '@angular/core';
import {Http, Headers} from "@angular/http";
import 'rxjs/add/operator/map';

@Injectable()
export class ConsumerPurposeList {

    constructor(private _http:Http) {

    }

    getConsumerPurposeList() {
        console.log('Cir purpose Name ------------------------------------ ');
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');
         
        return this._http.get('http://localhost:8080/EirWeb2/eir/getConsumerPurposeList').map(res=>res.json());
    }

    getConsumerFinancialPurposeList(purposeId) {
        console.log('Cir purpose Name ------------------------------------ ');
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');
         
        return this._http.get('http://localhost:8080/EirWeb2/eir/getConsumerFinancialPurposeList?purposeId=' + purposeId).map(res=>res.json());
    }

    getGender() {
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');
        return this._http.get('http://localhost:8080/EirWeb2/eir/getGender').map(res=>res.json());
    }
    getFrequency() {
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');
        return this._http.get('http://localhost:8080/EirWeb2/eir/getFrequency').map(res=>res.json());
        
    }

}