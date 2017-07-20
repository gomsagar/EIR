import { Component,Input } from '@angular/core';
import { Router} from '@angular/router';
import{FormGroup,FormBuilder,FormControl, Validators} from '@angular/forms';
import{AppService} from '../services/eir.callController';
import { DatePickerOptions, DateModel } from 'ng2-datepicker';

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
public reqId : number;
public earlierRequestList =<any>[];
private requestStatus =<any>[];
data =<any>{};
private requestIdFromUser: number;
options: DatePickerOptions;
 currentDate : Date;
dateExpires : Date;
requisitionForm: FormGroup; 
submitted:boolean = false;
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
  constructor(private router: Router,private _appService:AppService,public fb1: FormBuilder){ 
    this.options = new DatePickerOptions();
    this.currentDate = new Date();
      this.dateExpires = this.currentDate;
       this.requisitionForm = this.fb1.group({
         'requestId'     : [null,  Validators.compose([Validators.pattern('[0-9]{1,10}')])]
       });
  }

   back()
    {
        this.router.navigate(['home']);
    }
  
  submit(requestId)
  {
    console.log("Inside submit method....."+requestId);
    this.router.navigate(['viewEnquiryComponent'],{queryParams: { requestId: requestId}});
  }
validate(){
  
}
  
  ViewEarlierEnq()
  {
    this.submitted = true;
    console.log("Inside ViewEarlierEnq........");
    console.log("Data........"+ this.data);
    this._appService.getRequestData(this.data).subscribe((earlierRequestData) => {
      

          if(null != earlierRequestData && earlierRequestData.length > 0)
          {
              console.log("Inside if...........");
              this.earlierRequestList = earlierRequestData;
              for(var i=0;i<this.earlierRequestList.length;i++)
              {
                this.reqId = this.earlierRequestList[i].requestId;
              }
          } 
          else
          {
              console.log("Inside else...........");
              this.earlierRequestList = [];
              alert("No Data Found.");
          }         
        });

        // if(this.earlierRequestList.isEmpty()){
        //    console.log("Inside ...........");
        //     alert("Please enter the proper RequestId or Date....");
        // }
  }
}
