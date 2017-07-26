import { Component,Input } from '@angular/core';
import {MyDatePicker,IMyDpOptions,IMyDate} from 'mydatepicker';
import { DatePickerOptions, DateModel } from 'ng2-datepicker';
import{FormGroup,FormBuilder,FormControl, Validators} from '@angular/forms';
import {Router,ActivatedRoute} from '@angular/router';
import { LoaderService } from '../services/eir.loader';
import{AppService} from '../services/eir.callController';

@Component({
  selector: 'crmAdmin',
  templateUrl: '../html/crmAdmin.html',
  styleUrls: ['../app.component.css'],
  providers: [AppService]
})
export class CrmAdmin 
{
    data =<any>{};
    d = new Date();
    year = this.d.getFullYear();
    month = this.d.getMonth();
    day = this.d.getDate();
    mind:String;
    options: DatePickerOptions;
    currentDate : Date;
    dateExpires : Date;
    requisitionForm: FormGroup; 
    backRequestedId : string;
    fromDateBack : String;
    toDateBack : String;
    crmAdminRequestData=<any>[];
    requestId:number;
    submitted:boolean = false;
    formDateObj : any = {
        "day": "", "month": "", "year": "", "formatted": "", "momentObj": "" 
    };
    toDateObj: any = {
        "day": "", "month": "", "year": "", "formatted": "", "momentObj": "" 
    };

    private myDatePickerOptions: IMyDpOptions = {
            // other options...
            showInputField:true,
            minYear:this.year-100,
            maxYear:this.year,
            disableSince: { year: this.year, month: this.month+1, day: this.day },
            dateFormat: 'yyyy-mm-dd',
            editableDateField:false
        };

        constructor(public fb1: FormBuilder,private _appService:AppService,private router: Router,private _routeParams: ActivatedRoute,private loaderService: LoaderService){
            this.options = new DatePickerOptions();
            this.currentDate = new Date();
            this.dateExpires = this.currentDate;

            this.requisitionForm = this.fb1.group({
            'requestId' : [null, Validators.pattern('[0-9]{1,10}')]
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
        }

        submit(requestId)
        { 
            // this.router.navigate(['viewEnquiryComponent'],{queryParams: { requestId: requestId, searchRequestId: this.data.requestId,
            // fromDate : this.fromDateBack , toDate : this.toDateBack}});
            this.router.navigate(['crmAdminApproval']);
        }

        back()
        {
            this.router.navigate(['home']);
        }

    ViewKycApprovalEnq()
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
                if((this.data.fromDate.date.year <= this.data.toDate.date.year) && (this.data.fromDate.date.month <= this.data.toDate.date.month) && (this.data.fromDate.date.day <= this.data.toDate.date.day))
                {
                this.serviceCallForViewData(this.data);
                }
                else
                {
                this.crmAdminRequestData = [];
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
    this.loaderService.display(true);
        this._appService.getRequestDataForCRMAdmin(this.data).subscribe((crmAdminRequestData) => 
        {
        if(null != crmAdminRequestData && crmAdminRequestData.length > 0)
            { 
                this.loaderService.display(true);
                console.log("Inside if...........");
                this.crmAdminRequestData = crmAdminRequestData;
                for(var i=0;i<this.crmAdminRequestData.length;i++)
                {
                    this.requestId = this.crmAdminRequestData[i].requestId;
                }
            } 
            else
            {
                console.log("Inside else...........");
                this.crmAdminRequestData = [];
                this.loaderService.display(false);
                alert("No Data Found.");
            }    
        this.loaderService.display(false);    
        });
    }
}