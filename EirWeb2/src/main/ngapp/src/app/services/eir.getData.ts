import { Injectable, Inject } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { APP_CONFIG, IAppConfig } from '../app.config';

@Injectable()
export class DataService {
    public serviceUrl : string;
    constructor(private _http: Http, @Inject(APP_CONFIG) private config: IAppConfig) {
        this.serviceUrl = this.config.apiEndpointForLocalHost;
    }

    getData() 
    {
       return this._http.get(this.serviceUrl+ 'getEligibleProduct')
            .map((res:Response) => res.json());            
    }

    getCount() 
    {
       return this._http.get(this.serviceUrl+ 'getResponseObject')
            .map((res:Response) => res.json());            
    }

    getUserFlag() 
    {
       return this._http.get(this.serviceUrl+ 'getUserFlag')
            .map((res:Response) => res.json());            
    }

    getEarlierRequestData(userID)
    {
             return this._http.get(this.serviceUrl+ 'getEarlierRequest?userID=' + userID)
            .map((res:Response) => res.json());
    }
    getSelectedProduct(reqID)
    {
         return this._http.get(this.serviceUrl+ 'getSelectedProduct?reqID=' + reqID)
            .map((res:Response) => res.json()); 
    }
    // uploadKyc(formData,requestId,data){
   
    //    return this._http.post(this.serviceUrl+ 'uploadKYCDocuments?requestId='+requestId, data)
    //     .map(res => res.json())
        
    // }
    uploadKyc(formData,requestId){
   
       return this._http.post(this.serviceUrl+ 'uploadKYCDocuments?requestId='+requestId, formData)
        .map(res => res)
        
    }
}