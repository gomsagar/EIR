import { Injectable, Inject } from '@angular/core';
import {Http, Headers} from "@angular/http";
import 'rxjs/add/operator/map';

@Injectable()
export class AppService {

    constructor(private _http:Http) {

    }

    submit(data) {
        console.log(data);
       
        var head = new Headers();
        head.append('Content-Type', 'application/json');
         
        return this._http.post('http://localhost:8080/EirWeb2/eir/eir/getReport',
        JSON.stringify(data), { 
           headers:head
        })
        .map(res=>res.json());
    }
    submitInfo(info) {
        console.log(info);
       
        var head = new Headers();
        head.append('Content-Type', 'application/json');
         
        return this._http.post('http://localhost:8080/EirWeb2/eir/eir/getInfo',
        JSON.stringify(info), { 
           headers:head
        })
        .map(res=>res.json());
    }
}