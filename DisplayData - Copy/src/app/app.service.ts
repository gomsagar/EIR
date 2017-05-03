import { Injectable, Inject } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class HelloService {

    constructor(private _http: Http) {

        console.log('http respnce = '+Http);
    }

    getTest() {
       //return this._http.get('https://jsonplaceholder.typicode.com/posts').map((res:Response) => res.json());
       //return this._http.get('https://data.gov.in/api/datastore/resource.json?resource_id=3f328009-8f64-426d-9228-750a3fe8e326&api-key=22395c6ce991fd09c26a420aaa4a7204').map((res:Response) => res.json());
      // return this._http.get('http://localhost:8080/SpringMVC/rest/kfc/brands/').map((res:Response) => res.json());
       //return this._http.get('http://localhost:8080/RESTfulExample/json/get').map((res:Response) => res.json());
       return this._http.get('http://localhost:8080/EirWeb2/getAddress').map((res:Response) => res.json());
    }
}