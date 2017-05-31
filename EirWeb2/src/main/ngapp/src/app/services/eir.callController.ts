import { Injectable, Inject } from '@angular/core';
import {Http, Headers} from "@angular/http";
import 'rxjs/add/operator/map';
import { Subject }    from 'rxjs/Subject';

@Injectable()
export class AppService {
static count : number=1;
    constructor(private _http:Http) {

    }

    submit(data) {
        console.log(data);
       
        var head = new Headers();
        head.append('Content-Type', 'application/json');
         
        return this._http.post('http://localhost:8080/EirWeb2/eir/getReport',
        JSON.stringify(data), { 
           headers:head
        })
        .map(res=>res.json());
    }
    submitInfo(info) {
        console.log(info);
        debugger;
        info.bir.cinNumber = info.bir.Cin;
        info.bir.entityName = info.bir.Name;
        info.cir.state = info.cir.stateCode;
        var head = new Headers();
        head.append('Content-Type', 'application/json');
         
        return this._http.post('http://localhost:8080/EirWeb2/eir/getInfo',
        JSON.stringify(info), { 
           headers:head
        })
        .map(res=>res.json());
    }
}