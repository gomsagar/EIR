import { Component,Input } from '@angular/core';
import { Router} from '@angular/router';
//import{DataService} from '../services/eir.getData';
import{AppService} from '../services/eir.callController';

@Component({
  selector: 'viewEarlierRequest',
  templateUrl: '../html/viewEarlierRequest.html',
  providers: [AppService]
})
export class ViewEarlierRequestComponent 
{

private smeReportStatus:string;
private letigationReportStatus:string;
private newsFeedReportStatus:string;
private comboWSReportStatus:string;
private comboWOSReportStatus:string;
private birReportStatus:string;
private commWOSReportStatus:string;
private commWSReportStatus:string;
private reqId : number;
private userId:number=1;
public earlierRequestList =<any>[];
private requestStatus =<any>[];
data =<any>{};
private requestIdFromUser: number;
  ngOnInit(){
    // debugger;
    // this._dataService.getEarlierRequestData(this.userId).subscribe((earlierRequestData) => {
          
    //       if(null != earlierRequestData){
    //         this.earlierRequestList = earlierRequestData;
    //         for(var i=0;i<this.earlierRequestList.length;i++){
    //             this.reqId = this.earlierRequestList[i].requestId;
    //             // console.log("this.reqId"+this.earlierRequestList[i].requestId);
    //             // console.log("this.smeStatus"+this.earlierRequestList[i].smeStatus);
    //             // console.log("this.smeReportStatus"+this.earlierRequestList[i].smeReportStatus);
    //         }
    //       }
          
    //     });

  }
  constructor(private router: Router,private _appService:AppService){ }

   back()
    {
        this.router.navigate(['home']);
    }
  
  submit()
  {
    console.log("Inside submit method.....");
    this.router.navigate(['viewEnquiryComponent']);
  }

  
  ViewEarlierEnq()
  {
    debugger;
    console.log("Inside ViewEarlierEnq........");
    console.log("Data........"+ this.data);
    this._appService.getRequestData(this.data).subscribe((earlierRequestData) => {
      
          if(null != earlierRequestData){
            this.earlierRequestList = earlierRequestData;
            for(var i=0;i<this.earlierRequestList.length;i++){
                this.reqId = this.earlierRequestList[i].requestId;
            }
          }          
        });
  }
}
