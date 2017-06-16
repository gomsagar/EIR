import { Injectable, Inject } from '@angular/core';
import {Http, Headers} from "@angular/http";
import 'rxjs/add/operator/map';

@Injectable()
export class RelationTypeList {

    constructor(private _http:Http) {

    }

    getRelationTypeList() {
        console.log('Cir purpose Name ------------------------------------ ');
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');
         
        return this._http.get('http://localhost:8080/EirWeb2/eir/getRelationTypeList').map(res=>res.json());
    }
}