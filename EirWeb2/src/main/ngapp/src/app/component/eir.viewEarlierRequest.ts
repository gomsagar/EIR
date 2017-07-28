import { Component, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { AppService } from '../services/eir.callController';
import { DatePickerOptions, DateModel } from 'ng2-datepicker';
import { LoaderService } from '../services/eir.loader';
import { MyDatePicker, IMyDpOptions, IMyDate } from 'mydatepicker';
import * as _ from 'underscore';
import { PagerService } from '../services/pager.service'

@Component({
  selector: 'viewEarlierRequest',
  templateUrl: '../html/viewEarlierRequest.html',
  styleUrls: ['../app.component.css'],
  providers: [AppService]
})
export class ViewEarlierRequestComponent {

  private smeReportStatus: string;
  private letigationReportStatus: string;
  private newsFeedReportStatus: string;
  private comboWSReportStatus: string;
  private comboWOSReportStatus: string;
  private birReportStatus: string;
  private commWOSReportStatus: string;
  private commWSReportStatus: string;
  public reqId: number;
  backRequestedId: string;
  fromDateBack: String;
  toDateBack: String;
  public earlierRequestList = <any>[];
  private requestStatus = <any>[];
  data = <any>{};
  private requestIdFromUser: number;
  options: DatePickerOptions;
  currentDate: Date;
  dateExpires: Date;
  requisitionForm: FormGroup;
  submitted: boolean = false;
  fromDateStr: String[];
  toDateStr: String[];
  formDateObj: any = {
    formatted: "",
    date: {"day": "", "month": "", "year": "",  "momentObj": ""}
  };
  toDateObj: any = {
    formatted: "",
    date: {"day": "", "month": "", "year": "",  "momentObj": ""}
  };
  showLoader: boolean;
  d = new Date();
  year = this.d.getFullYear();
  month = this.d.getMonth();
  day = this.d.getDate();
  mind: String;
  //options: DatePickerOptions;
  private myDatePickerOptions: IMyDpOptions = {
    // other options...
    showInputField: true,
    minYear: this.year - 100,
    maxYear: this.year,
    disableSince: { year: this.year, month: this.month + 1, day: this.day + 1 },
    dateFormat: 'yyyy-mm-dd',
    editableDateField: false
  };
  private allItems: any[];
  // pager object
  pager: any = {};
  // paged items
  pagedItems: any[];
  ngOnInit() {
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
  constructor(private router: Router,private _appService:AppService,private loaderService: LoaderService,public fb1: FormBuilder,private _routeParams: ActivatedRoute, private pagerService: PagerService){ 
    this.loaderService.display(true);
   this.loaderService.status.subscribe((val: boolean) => {
            this.showLoader = val;

    });

    this.options = new DatePickerOptions();
    this.currentDate = new Date();
    this.dateExpires = this.currentDate;

    this.requisitionForm = this.fb1.group({
      'requestId': [null, Validators.pattern('[0-9]{1,10}')]
    });
    this._routeParams.queryParams.subscribe(params => {
      this.backRequestedId = params["searchRequestId"],
        this.fromDateBack = params["fromDate"],
        this.toDateBack = params["toDate"];
    });
  debugger;
    if ((this.backRequestedId !== null && this.backRequestedId !== undefined) || (this.fromDateBack !== null
      && this.fromDateBack !== undefined) || (this.toDateBack !== null && this.toDateBack !== undefined)) 
      {
        this.data.requestId = this.backRequestedId;

        this.formDateObj.formatted = this.fromDateBack;
        this.fromDateStr = this.fromDateBack.split("-");
        this.formDateObj.date.day = this.fromDateStr[2];
        this.formDateObj.date.month = this.fromDateStr[1];
        this.formDateObj.date.year = this.fromDateStr[0];
        this.data.fromDate = this.formDateObj;

        this.toDateObj.formatted = this.toDateBack;
        this.toDateStr = this.toDateBack.split("-");
        this.toDateObj.date.day = this.toDateStr[2];
        this.toDateObj.date.month = this.toDateStr[1];
        this.toDateObj.date.year = this.toDateStr[0];
        this.data.toDate = this.toDateObj;

        this.serviceCallForViewData(this.data);
      }
      this.loaderService.display(false);
  }


  back() {
    this.router.navigate(['home']);
  }

  submit(requestId) {
    console.log("Inside submit method....." + requestId + " - " + this.fromDateBack + " - " + this.toDateBack);
    this.router.navigate(['viewEnquiryComponent'], {
      queryParams: {
        requestId: requestId, searchRequestId: this.data.requestId,
        fromDate: this.fromDateBack, toDate: this.toDateBack
      }
    });
  }
  validate() {

  }

  ViewEarlierEnq() {
    debugger;
    this.submitted = true;
    console.log("Inside ViewEarlierEnq........");
    console.log("Data........" + this.data);
    this.submitted = true;
    if (this.data.fromDate != null && this.data.fromDate != undefined) {
      this.fromDateBack = this.data.fromDate.formatted;
    }
    if (this.data.toDate != null && this.data.toDate != undefined) {
      this.toDateBack = this.data.toDate.formatted;
    }
    if(!this.customValidator())
    {
      debugger;
      this.pagedItems = [];
      this.allItems = [];
       alert("Please Enter Search Criteria!");
       return;      
    }
    if (this.requisitionForm.valid) 
    {
      if(this.data.requestId == null || this.data.requestId == undefined || this.data.requestId == '')
      {
                  if (this.data.fromDate !== undefined && this.data.fromDate !== null && this.data.fromDate.date !== undefined  && this.data.fromDate.date !== null
                    && (this.data.toDate == undefined ||  this.data.toDate == null || this.data.toDate.date == undefined  || this.data.toDate.date == null) ) 
                    {
                      this.pagedItems = [];
                      this.allItems = [];
                      alert("Please Enter To Date!")
                      
                    }
                    else if(this.data.toDate !== undefined && this.data.toDate !== null && this.data.toDate.date !== undefined  && this.data.toDate.date !== null
                    && (this.data.fromDate == undefined ||  this.data.fromDate == null || this.data.fromDate.date == undefined  || this.data.fromDate.date == null) )
                    {
                      this.pagedItems = [];
                      this.allItems = [];
                      alert("Please Enter From Date!");
                      
                    }
                  else
                  {
                        if ((this.data.fromDate.date.year <= this.data.toDate.date.year) && (this.data.fromDate.date.month <= this.data.toDate.date.month)
                          && (this.data.fromDate.date.day <= this.data.toDate.date.day)) {
                          this.serviceCallForViewData(this.data);
                        }
                        else {
                          this.pagedItems = [];
                          this.allItems = [];
                          alert("To Date should be greater than From Date!");
                        }
                  }

        }
        else {
          this.serviceCallForViewData(this.data);
        }
    }
    else{
      this.pagedItems = [];
      this.allItems = [];
      alert("Please Enter Search Criteria!");
    }
  }

    /*serviceCallForViewData(formParameter)
    {      
      this.loaderService.display(true);
        this._appService.getRequestData(this.data).subscribe((earlierRequestData) => 
        { 
          // set items to json response
          this.allItems = earlierRequestData;
          // initialize to page 1
          this.setPage(1);
          if(null != earlierRequestData && earlierRequestData.length > 0)
              { 
                  this.loaderService.display(true);
                  console.log("Inside if...........");
                  this.earlierRequestList = earlierRequestData;
                  console.log("Inside if..........."+this.earlierRequestList.length+" - "+this.earlierRequestList);
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
      }*/
     

    serviceCallForViewData(formParameter)
    {    
        this.loaderService.display(true);
        this._appService.viewRequestIds(this.data).subscribe((earlierRequestData) => 
        { 
              // set items to json response
              this.allItems = earlierRequestData;
              debugger;
              if(this.allItems == undefined || this.allItems.length <= 0 )
              {
                this.pagedItems = [];
                this.allItems = [];
                  alert("No Data Found.");
              }
              
             //return this.allItems;
              // initialize to page 1
              this.setPage(1);
                
           this.loaderService.display(false);    
        });

        this.loaderService.display(false);
      }

      setPage(page: number) 
      { debugger;

        this.pager = this.pagerService.getPager(this.allItems.length, page);
            if (page < 1 || page > this.pager.pages.length) 
            {
                return;
            }
            // get pager object from service
            console.log("this.allItems -------- "+this.allItems);
            //this.pager = this.pagerService.getPager(this.allItems.length, page);
            let startId = this.allItems[this.pager.startIndex];
            let endId = this.allItems[this.pager.endIndex];
            this.data.startIndex = startId;
            this.data.endIndex = endId;

            this._appService.getRequestData(this.data).subscribe((earlierRequestData) => 
            {
                debugger;
                  // set items to json response
                  this.pagedItems = earlierRequestData;
                  // initialize to page 1
                  if(null != earlierRequestData && earlierRequestData.length > 0)
                      { 
                            this.loaderService.display(true);
                            console.log("Inside if...........");
                            this.pagedItems = earlierRequestData;
                            console.log("Inside if..........."+this.pagedItems.length+" - "+this.pagedItems);
                      } 
                      else
                      {
                            console.log("Inside else...........");
                            this.pagedItems = [];
                            this.allItems = [];
                            this.loaderService.display(false);
                            alert("No Data Found.");
                      }
                this.loaderService.display(false);
              });
                // get current page of items
                debugger;
                this.pagedItems = this.allItems.slice(this.pager.startIndex, this.pager.endIndex + 1);
                this.loaderService.display(false);
      }

          customValidator() 
          {
              if(( this.data.fromDate == null || this.data.fromDate == undefined ||this.data.fromDate.formatted == undefined || this.data.fromDate.formatted == null)
                && ( this.data.toDate == null || this.data.toDate == undefined || this.data.toDate.formatted == undefined || this.data.toDate.formatted == null)
                &&( this.data.requestId == undefined || this.data.requestId == ""))
              {
                  return false;
              }
              else
              {
                return true;
              }
          }
}
