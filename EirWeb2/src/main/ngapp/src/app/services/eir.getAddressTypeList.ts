import { Injectable, Inject } from '@angular/core';
import {Http, Headers} from "@angular/http";
import 'rxjs/add/operator/map';

@Injectable()
export class AddressTypeList {

    constructor(private _http:Http) {

    }

    getAddressTypeList() {
        console.log('Address Type Name ------------------------------------ ');
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');
         
        return this._http.get('http://localhost:8080/EirWeb2/eir/getAddressTypeList').map(res=>res.json());
    }
}