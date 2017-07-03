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

    ngOnInit(){

        this._appService.getViewRequest(this.requestId).subscribe((viewRequestData) =>{
            debugger;
            console.log("Inside view enq constructor");
            console.log("viewRequestData BIR:::::"+viewRequestData.birObject.birReportStatus);
            console.log("viewRequestData CIR:::::"+viewRequestData.cirWithScoreObject.cirWithScoreReportStatus);
             this.viewRequestData =  viewRequestData ;
           // console.log("viewRequestData CIR:::::"+viewRequestData.cirObject.cirReportStatus);
           // console.log("viewRequestData consumer:::::"+viewRequestData.consumerObject.consumerReportStatus);
             this.birObject = viewRequestData.birObject;
             this.cirWithScoreObject = viewRequestData.cirWithScoreObject;
             this.cirWithOutScoreObject = viewRequestData.cirWithOutScoreObject;
             this.comboWithScoreObject = viewRequestData.comboWithScoreObject;
             this.comboWithOutScoreObject = viewRequestData.comboWithOutScoreObject;
    });

    }
    constructor(private router: Router,private _appService:AppService){
       
        this.birObject = [];
        this.cirWithScoreObject = <any>[];
         this.cirWithOutScoreObject = <any>[];
         this.comboWithScoreObject = <any>[];
          this.comboWithOutScoreObject = <any>[];
          this.viewRequestData= <any>[];
       
  }
   back()
    {
        this.router.navigate(['home']);
    }
}
