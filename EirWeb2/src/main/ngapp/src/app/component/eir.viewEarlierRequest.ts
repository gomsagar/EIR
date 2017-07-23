import { Component,Input } from '@angular/core';
import {Router,ActivatedRoute} from '@angular/router';
import{FormGroup,FormBuilder,FormControl, Validators} from '@angular/forms';
import{AppService} from '../services/eir.callController';
import { DatePickerOptions, DateModel } from 'ng2-datepicker';
import { LoaderService } from '../services/eir.loader';

@Component({
  selector: 'viewEarlierRequest',
  templateUrl: '../html/viewEarlierRequest.html',
  styleUrls: ['../app.component.css'],
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
backRequestedId : string;
fromDateBack : String;
toDateBack : String;
public earlierRequestList =<any>[];
private requestStatus =<any>[];
data =<any>{};
private requestIdFromUser: number;
options: DatePickerOptions;
 currentDate : Date;
dateExpires : Date;
requisitionForm: FormGroup; 
submitted:boolean = false;
formDateObj : any = {
    "day": "", "month": "", "year": "", "formatted": "", "momentObj": "" 
};
toDateObj: any = {
    "day": "", "month": "", "year": "", "formatted": "", "momentObj": "" 
};
 showLoader:boolean;
 
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
  constructor(private router: Router,private _appService:AppService,private loaderService: LoaderService,public fb1: FormBuilder,private _routeParams: ActivatedRoute){ 
    this.loaderService.display(true);
   this.loaderService.status.subscribe((val: boolean) => {
            this.showLoader = val;

        });

   this.options = new DatePickerOptions();
    this.currentDate = new Date();
      this.dateExpires = this.currentDate;

       this.requisitionForm = this.fb1.group({
         'requestId'     : [null, Validators.pattern('[0-9]{1,10}')]
       });
this._routeParams.queryParams.subscribe(params => { this.backRequestedId = params["searchRequestId"], 
                                                          this.fromDateBack = params["fromDate"],
                                                          this.toDateBack = params["toDate"];
                                                        });

       if((this.backRequestedId !== null && this.backRequestedId !== undefined) || (this.fromDateBack !== null && this.fromDateBack !== undefined) || (this.toDateBack !== null && this.toDateBack !== undefined))
        {
            this.data.requestId = this.backRequestedId;
            
            this.formDateObj.formatted = this.fromDateBack;
            this.data.fromDate = this.formDateObj;
            this.toDateObj.formatted = this.toDateBack;
            this.data.toDate = this.toDateObj;
            
            this.serviceCallForViewData(this.data);
        }
       this.loaderService.display(false);
  }


   back()
    {
        this.router.navigate(['home']);
    }
  
  submit(requestId)
  {    
    console.log("Inside submit method....."+requestId+" - "+this.fromDateBack +" - "+this.toDateBack);
    this.router.navigate(['viewEnquiryComponent'],{queryParams: { requestId: requestId, searchRequestId: this.data.requestId,
         fromDate : this.fromDateBack , toDate : this.toDateBack}});
  }
validate(){
  
}
  
  ViewEarlierEnq()
  {
    
    this.submitted = true;
    console.log("Inside ViewEarlierEnq........");
    console.log("Data........"+ this.data);
    this.submitted = true;
    if(this.data.fromDate != null && this.data.fromDate != undefined)
    {
        this.fromDateBack = this.data.fromDate.formatted;
    }
    if(this.data.toDate != null && this.data.toDate != undefined)
    {
        this.toDateBack = this.data.toDate.formatted;
    }
    if(this.requisitionForm.valid )
      {
        if(this.data.fromDate !== undefined && this.data.toDate !== undefined && this.data.fromDate !== null && this.data.toDate !== null)
        {
            if((this.data.fromDate.year <= this.data.toDate.year) && (this.data.fromDate.month <= this.data.toDate.month) && (this.data.fromDate.day <= this.data.toDate.day))
            {
              this.serviceCallForViewData(this.data);
            }
            else
            {
              this.earlierRequestList = [];
              alert("To Date should be greater than From Date!");
            }
        }
        else
          {
            this.serviceCallForViewData(this.data);
          }
      }
    }

    serviceCallForViewData(formParameter)
    {      
      debugger;
      this.loaderService.display(true);
        this._appService.getRequestData(this.data).subscribe((earlierRequestData) => 
        {
          if(null != earlierRequestData && earlierRequestData.length > 0)
              { 
                  this.loaderService.display(true);
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
                  this.loaderService.display(false);
                  alert("No Data Found.");
              }    
	      this.loaderService.display(false);    
          });
      }
  
}
