import { Injectable, Inject } from '@angular/core';
import {Http, Headers} from "@angular/http";
import 'rxjs/add/operator/map';
import { Subject }    from 'rxjs/Subject';

@Injectable()
export class AppService {
static count : number=1;

    constructor(private _http:Http) {

    }

    getNativeWindow() {
        return window;
    }
    submit(data) {
        console.log(data);
       
        var head = new Headers();
        head.append('Content-Type', 'application/json');
         
        return this._http.post('http://localhost:8080/EirWeb2/eir/saveProductSelection',
        JSON.stringify(data), { 
           headers:head
        })
        .map(res=>res.json());
    }
    createEnquiry(info) {
        console.log(info);
        debugger;
        if(info.isBIRActive == 'true')
        {
            info.bir.cinNumber = info.bir.Cin;
            info.bir.entityName = info.bir.Name;
        }
        //info.cir.state = info.cir.stateCode;
        var head = new Headers();
        head.append('Content-Type', 'application/json');
         
        return this._http.post('http://localhost:8080/EirWeb2/eir/createEnquiry',
        JSON.stringify(info), { 
           headers:head
        })
        .map(res=>res.json());
    }

    getViewRequest(requestId){
    return this._http.get('http://localhost:8080/EirWeb2/eir/getViewRequest?requestId='+ requestId)
    .map(res=>res.json());
    }
    

    getRequestData(viewEarlierEnqData)
    {
        var head = new Headers();
        head.append('Content-Type', 'application/json');
         
         return this._http.post('http://localhost:8080/EirWeb2/eir/getRequestedData',
             JSON.stringify(viewEarlierEnqData),{
                    headers:head
             })
            .map(res=>res.json());
    }
}