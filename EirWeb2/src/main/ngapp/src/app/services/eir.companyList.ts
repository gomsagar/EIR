import { Injectable, Inject } from '@angular/core';
import 'rxjs/add/operator/map';
import { Http, Response } from '@angular/http';
import { APP_CONFIG, IAppConfig } from '../app.config';

@Injectable()
export class CompanyListService {
    public serviceUrl : string;

    constructor(private _http: Http, @Inject(APP_CONFIG) private config: IAppConfig) {
        this.serviceUrl = this.config.apiEndpointForLocalHost;
    }

    getCompanyList() {
       return this._http.get(this.serviceUrl+ 'sendReport')
            .map((res:Response) => res.json());
    }

   }