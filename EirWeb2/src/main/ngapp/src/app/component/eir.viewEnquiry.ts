import { Component,Input } from '@angular/core';
import { Router} from '@angular/router';
import{AppService} from '../services/eir.callController';

@Component({
  selector: 'viewEnquiryComponent',
  templateUrl: '../html/ViewEnquiry.html',
  providers:[AppService]
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


    ngOnInit(){

        this._appService.getViewRequest(this.requestId).subscribe((viewRequestData) =>{
           // debugger;
            console.log("Inside view enq constructor");
           // console.log("viewRequestData BIR:::::"+viewRequestData.birObject.birReportStatus);
           // console.log("viewRequestData CIR:::::"+viewRequestData.cirWithScoreObject.cirWithScoreReportStatus);
             
             this.birObject = viewRequestData.birObject;
             this.cirWithScoreObject = viewRequestData.cirWithScoreObject;
             this.cirWithOutScoreObject = viewRequestData.cirWithOutScoreObject;
             this.comboWithScoreObject = viewRequestData.comboWithScoreObject;
             this.comboWithOutScoreObject = viewRequestData.comboWithOutScoreObject;

            this.btnCIRWS    = this.statusButton(viewRequestData.cirWithScoreObject.cirWithScoreReportStatus);
            this.btnCIRWOS   = this.statusButton(viewRequestData.cirWithOutScoreObject.cirWithOutScoreReportStatus);
            this.btnCOMBOWS  = this.statusButton(viewRequestData.comboWithScoreObject.comboWithScoreReportStatus);
            this.btnCOMBOWOS = this.statusButton(viewRequestData.comboWithOutScoreObject.comboWithoutScoreReportStatus);
            this.btnBIR      = this.statusButton(viewRequestData.birObject.birReportStatus);

    });

    }
    constructor(private router: Router,private _appService:AppService){
       
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

  }
   back()
    {
        this.router.navigate(['home']);
    }

    download()
    {
        console.log("Download called");
    }

    RESUBMIT()
    {
         console.log("RESUBMIT called");
    }

    VIEW()
    {
         console.log("VIEW called");
    }

    submit(value)
    {
        if(value == "RESUBMIT")
        {
            this.RESUBMIT();
        }
        else if(value == "VIEW")
        {
            this.VIEW();
        }
    }

    statusButton(status)
    {
        if(status =="Completed")
        {
           this.btnStatus = "VIEW";
        }
        else if(status=="In Process")
        {
            this.btnStatus = "";
        }
        else if(status=="Error")
        {
            this.btnStatus = "RESUBMIT";
        }
        
        return this.btnStatus;
    }
}
