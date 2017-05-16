import { Injectable, Inject } from '@angular/core';
import 'rxjs/add/operator/map';
import { Http, Response } from '@angular/http';

@Injectable()
export class CompanyListService {

    constructor(private _http: Http) {}

    getCompanyList() {
       return this._http.get('http://localhost:8080/EirWeb2/sendReport')
            .map((res:Response) => res.json());
    }

   }