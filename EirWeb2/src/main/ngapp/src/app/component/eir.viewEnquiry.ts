import { Component,Input,Inject } from '@angular/core';
import { Router,ActivatedRoute} from '@angular/router';
import{AppService} from '../services/eir.callController';
import{DataService} from '../services/eir.getData';
import {ViewEarlierRequestComponent} from './eir.viewEarlierRequest';
import { APP_CONFIG, IAppConfig } from '../app.config';

@Component({
  selector: 'viewEnquiryComponent',
  templateUrl: '../html/ViewEnquiry.html',
  providers:[AppService,DataService]
})
export class ViewEnquiryComponent
{
    requestId:number=1;
    private requestStatus =<any>[]; 
    private birObject;
    private cirWithScoreObject;
    private cirWithOutScoreObject;
    private comboWithScoreObject;
    private comboWithOutScoreObject;
    private viewRequestData;
    private btnCIRWS;
    private btnCIRWOS;
    private btnCOMBOWS;
    private btnCOMBOWOS;
    private btnBIR;
    public btnStatus:String;
    private isPDF:Boolean;
    private htmlString;
    nativeWindow: any;
    private cirRequestId;
    private birRequestId;
    private consumerRequestId;
    private reSubmitData = <any>[];
    public serviceUrl : string;
    ngOnInit(){
          this._appService.getViewRequest(this.requestId).subscribe((viewRequestData) =>{          
            
            console.log("Inside view enq constructor::::::"+this.requestId);
                        
             this.birObject = viewRequestData.birObject;
             this.cirWithScoreObject = viewRequestData.cirWithScoreObject;
             this.cirWithOutScoreObject = viewRequestData.cirWithOutScoreObject;
             this.comboWithScoreObject = viewRequestData.comboWithScoreObject;
             this.comboWithOutScoreObject = viewRequestData.comboWithOutScoreObject;
//debugger;
             

            // this.btnCIRWS    = this.statusButton(viewRequestData.cirWithScoreObject.cirWithScoreReportStatus);
            // this.btnCIRWOS   = this.statusButton(viewRequestData.cirWithOutScoreObject.cirWithOutScoreReportStatus);
            // this.btnCOMBOWS  = this.statusButton(viewRequestData.comboWithScoreObject.comboWithScoreReportStatus);
            // this.btnCOMBOWOS = this.statusButton(viewRequestData.comboWithOutScoreObject.comboWithoutScoreReportStatus);
            // this.btnBIR      = this.statusButton(viewRequestData.birObject.birReportStatus);

    });

}
    constructor(private router: Router,private _appService:AppService,private _dataService:DataService,
    private _routeParams: ActivatedRoute, @Inject(APP_CONFIG) private config: IAppConfig){
      this.nativeWindow = _appService.getNativeWindow();
        this._routeParams.queryParams.subscribe(params => {this.requestId = params['requestId'] || 1});  
     this.birObject = [];
     this.cirWithScoreObject = <any>[];
     this.cirWithOutScoreObject = <any>[];
     this.comboWithScoreObject = <any>[];
     this.comboWithOutScoreObject = <any>[];
     this.viewRequestData= <any>[];

     this.btnCIRWS = "";
     this.btnCIRWOS = "";
     this.btnCOMBOWS = "";
     this.btnCOMBOWOS = "";
     this.btnBIR = "";
     this.serviceUrl = this.config.apiEndpointForLocalHost;

  }
   back()
    {
        this.router.navigate(['home']);
    }

    download(reportType)
    {
        this.isPDF = true;
        console.log("Download called");
        var url = this.serviceUrl+ "getPDFReport?requestId="+this.requestId +"&reportType=" + reportType +"&isPdf=" + this.isPDF;
        var newWindow = this.nativeWindow.open(url);           
    }

    resubmit(reportType)
    {
         console.log("RESUBMIT called");
        console.log("finised");
       
        if(reportType == 'CIRWS'){
            this._appService.sendReSubmitRequestForCIR(this.cirWithScoreObject.cirRequestId,this.cirWithScoreObject).subscribe((cirWithScoreObject) => {
                this.cirWithScoreObject = cirWithScoreObject;
            });
        }
        if(reportType == 'CIRWOS'){
            this._appService.sendReSubmitRequestForCIR(this.cirWithOutScoreObject.cirRequestId,this.cirWithOutScoreObject).subscribe((cirWithScoreObject) => {
                     this.cirWithOutScoreObject =cirWithScoreObject;
                        
            });
        }
        if(reportType == 'CWS'){
            this._appService.sendReSubmitRequestForCombo(this.requestId,this.comboWithScoreObject).subscribe((comboWithScoreObject) => {
                this.comboWithScoreObject = comboWithScoreObject;
                        
            });
        }
        if(reportType == 'CWOS'){
            this._appService.sendReSubmitRequestForCombo(this.requestId,this.comboWithOutScoreObject).subscribe((comboWithOutScoreObject) => {
                console.log(comboWithOutScoreObject);
                 this.comboWithOutScoreObject = comboWithOutScoreObject;                        
            });
        }
        if(reportType == 'BIR'){
            this._appService.sendReSubmitRequestForBIR(this.requestId,this.birObject.birRequestId).subscribe((earlierRequestData) => {
            });
        }
    }

    view(reportType)
    {
        console.log("Inside view method");        
        this.isPDF = false;
         console.log("VIEW called");
               
        var url =this.serviceUrl+ "getHTMLReport?requestId="+this.requestId +"&reportType=" + reportType +"&isPdf=" + this.isPDF;
        var newWindow = this.nativeWindow.open(url);   
    }

    //submit(value,reportType)
    //{
        // if(value == "RESUBMIT")
        // {
        //     this.RESUBMIT(reportType);
        // }
        // else if(value == "VIEW")
        // {
        //     this.VIEW(reportType);
        // }
   // }

    // statusButton(status)
    // {
    //     if(status =="Completed")
    //     {
    //        this.btnStatus = "VIEW";
    //     }
    //     else if(status=="In Process")
    //     {
    //         this.btnStatus = "";
    //     }
    //     else if(status=="Error")
    //     {
    //         this.btnStatus = "RESUBMIT";
    //     }
        
    //     return this.btnStatus;
    // }
}
