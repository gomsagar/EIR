import { Injectable, Inject } from '@angular/core';
import {Http, Headers} from "@angular/http";
import 'rxjs/add/operator/map';
import { Subject }    from 'rxjs/Subject';
import { APP_CONFIG, IAppConfig } from '../app.config';

@Injectable()
export class AppService {
@Inject('configuration') configuration:any;
public serviceUrl : string;

    constructor(private _http:Http, @Inject(APP_CONFIG) private config: IAppConfig) {
        this.serviceUrl = this.config.apiEndpointForLocalHost;
    }

    getNativeWindow() {
        return window;
    }
    submit(data, sentRequestId) {
        console.log(data);
       
        var head = new Headers();
        head.append('Content-Type', 'application/json');
         
        return this._http.post(this.serviceUrl+ 'saveProductSelection?sentRequestId='+ sentRequestId,
        JSON.stringify(data), { 
           headers:head
        })
        .map(res=>res.json());
    }
    createEnquiry(info) {
        console.log(info);
       
        if(info.isBIRActive == 'true')
        {
            info.bir.cinNumber = info.bir.Cin;
            info.bir.entityName = info.bir.Name;
        }
        //info.cir.state = info.cir.stateCode;
        var head = new Headers();
        head.append('Content-Type', 'application/json');
         
        return this._http.post(this.serviceUrl+ 'createEnquiry',
        JSON.stringify(info || null ), { 
           headers:head
        })
        .map(res=>res.toString);
    }

    getViewRequest(requestId){
    return this._http.get(this.serviceUrl+ 'getViewRequest?requestId='+ requestId)
    .map(res=>res.json());
    }
    

    getRequestData(viewEarlierEnqData)
    {
        var head = new Headers();
        head.append('Content-Type', 'application/json');
         
         return this._http.post(this.serviceUrl+ 'getEarlierEnquiryRequestData',
             JSON.stringify(viewEarlierEnqData),{
                    headers:head
             })
            .map(res=>res.json());
    }

    getRequestDataForCRMAdmin(crmAdminEnqData)
    {
        var head = new Headers();
        head.append('Content-Type', 'application/json');
         
         return this._http.post(this.serviceUrl+ 'getCrmAdminEnqData',
             JSON.stringify(crmAdminEnqData),{
                    headers:head
             })
            .map(res=>res.json());
    }

    sendReSubmitRequestForBIR(requestId,birRequestId){
          return this._http.get(this.serviceUrl+ 'reSubmitRequestForBIR?birRequestId='+birRequestId)
        .map(res=>res.json());
    }
    
     sendReSubmitRequestForCombo(requestId,comboRequest){
         var head = new Headers();
        head.append('Content-Type', 'application/json');
        
          return this._http.post(this.serviceUrl+ 'reSubmitRequestForCombo?requestId='+requestId,
            JSON.stringify(comboRequest),{
                headers:head
            }
          )
        .map(res=>res.json());
    }
     
     sendReSubmitRequestForCIR(cirRequestId,cirRequest){
          var head = new Headers();
        head.append('Content-Type', 'application/json');
       
        return this._http.post(this.serviceUrl+ 'reSubmitRequestForCIR?cirRequestId='+cirRequestId,
        
             JSON.stringify(cirRequest),{
             headers:head
        }
        
        )
            .map(res=>res.json());
    }
}