import { Injectable, Inject } from '@angular/core';
import {Http, Headers} from "@angular/http";
import 'rxjs/add/operator/map';
import { APP_CONFIG, IAppConfig } from '../../app.config';

@Injectable()
export class RelationTypeList {
    public serviceUrl : string;
    constructor(private _http:Http, @Inject(APP_CONFIG) private config: IAppConfig) {
        this.serviceUrl = this.config.apiEndpointForLocalHost;
    }

    getRelationTypeList() {
        console.log('Cir purpose Name ------------------------------------ ');
        var headr = new Headers();
        headr.append('Content-Type', 'application/json');
         
        return this._http.get(this.serviceUrl+ 'getRelationTypeList').map(res=>res.json());
    }
}