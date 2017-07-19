import { Component,Input,OnInit } from '@angular/core';
import { Router,ActivatedRoute} from '@angular/router';
import {HttpModule, Http} from "@angular/http";
import{CompanyListService} from '../services/eir.companyList';
import{CompanyNameService} from '../services/eir.sendCompName';
import{StateListService} from '../services/eir.stateList';
import{AddressTypeList} from '../services/eir.getAddressTypeList';
import{CirPurposeList} from '../services/eir.getCirPurposeList';
import{ReportTypeList} from '../services/dropdown/eir.getReportTypeList';
import{FormGroup,FormBuilder,FormControl, Validators} from '@angular/forms';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import{AppService} from '../services/eir.callController';
import{EirCreateComponent} from './eir.createEnquiry';
import { DatePickerOptions, DateModel } from 'ng2-datepicker';
import {ConsumerComponent} from './eir.consumer';
import{NewService} from '../services/eir.newService';
import { ControlMessages } from '../services/control.message.component';
import { InitalizeService } from '../services/eir.initalizeData';

interface MessageJson {
    name:string;
    cin:string;
}

@Component({
  selector: 'inputForEnquiry',
  templateUrl: '../html/inputForEnquiry.html',
 providers: [HttpModule,CompanyListService,AppService,CompanyNameService, StateListService,AddressTypeList,CirPurposeList,FormsModule,ReactiveFormsModule,NewService,ControlMessages,ReportTypeList]
})
export class InputForEnquiryComponent implements OnInit
{
    private _subscription;
    private jsonResponse: string;
    private birVal: string;
    private cirVal: string;
    private comboVal: string;
    private validForm: string;
    private messagess: Array<MessageJson>;
    submitted:boolean;
    public issOnlyBIR:boolean;
    public isCir:boolean;
    public isCombo:boolean;
    private route: ActivatedRoute;
    data=<any>{};
    value = <any>{};
    info= <any>{};
    company=<any>[];
    stateList=<any>[];
    addressTypeList=<any>[];
    cirPurposeList = <any>[];
    reportTypeList = <any>[];
    cinNumber=<any>[]; 
    temp = <any>[];
    private hasList:boolean=false;
    cirForm : FormGroup;
    birForm : FormGroup;
    cirForm2: FormGroup;
    formValid:boolean=false;
    isAddMore : boolean;
    consumerValid : boolean;
    requestId : number;
    //EirCreateComponent createComponent = new EirCreateComponent();

    commonArray: any = {
        requestId:'',
        isBIRActive:'',
        isCIRActive:'',
        isComboActive:'',
         bir: {companyName:'',company:''},
        cir: {companyName:'',productField:'',cirPurpose:'',amt:'',accType1:'',clientRefNo:'',accType2:'',cmpPan:'',addrType:'',addrLinen1:'',
              addrline2:'',city:'',cirState:'',pinCode:'',telephoneNo:'',cin:'',tin:'',emailId:'',triggers:''},
         consumerList: [ 
                {relationType:'',accountType:'',firstName:'',middleName:'',lastName:'',personPan:'',drivingLic:'',aadharhCard:'',voterId:'',
                rationCard:'',passportNo:'',homeTelephoneNo:'',officeTelephoneNo:'',mobileNo:'',birthDate:'',maritalStatus:'',gender:'',
                addressType :'' ,personAddrLine1:'',personAddrLine2:'',personCity:'',personState:'',personPinCode:'',amount:'',consumerPurpose:'', consumerFinancialPurpose:''}]};

        consumerData : any= [{relationType:'',accountType:'',firstName:'',middleName:'',lastName:'',personPan:'',drivingLic:'',aadharhCard:'',voterId:'',
                rationCard:'',passportNo:'',homeTelephoneNo:'',officeTelephoneNo:'',mobileNo:'',birthDate:'',maritalStatus:'',gender:'',
                addressType :'' ,personAddrLine1:'',personAddrLine2:'',personCity:'',personState:'',personPinCode:'',amount:'',consumerPurpose:'', consumerFinancialPurpose:''}]  ;

  ngOnInit()
  {
    if(this.comboVal == 'true' || this.cirVal == 'true')
    {
        this._stateListService.getStateList().subscribe((stateListSubs) => {

            this.stateList=stateListSubs;
                this._newService.setStateList(stateListSubs);
                console.log("responce   -  - "+ stateListSubs);
                if(stateListSubs!=null)
                {
                this.hasList=true;
                }
            });  
            
        this._addressTypeList.getAddressTypeList().subscribe((addressType) => {
            this.addressTypeList=addressType;
            this.jsonResponse = JSON.stringify(addressType);
            if(addressType!=null)
                {
                this.hasList=true;
                }
        });
        this._reportTypeList.getReportTypeList().subscribe((reportType) => {
            this.reportTypeList=reportType;
            this.jsonResponse = JSON.stringify(reportType);
            if(reportType!=null)
                {
                this.hasList=true;
                }
        });
        this._cirPurposeList.getCirPurposeList().subscribe((cirPurpose) => {
            this.cirPurposeList=cirPurpose;
            this.jsonResponse = JSON.stringify(cirPurpose);
            if(cirPurpose!=null)
                {
                this.hasList=true;
                }
        });
    }
  }
      
    constructor(private _cmpservice:CompanyListService,private _cmpname:CompanyNameService,private _newService :NewService,private controlMessage:ControlMessages,private _stateListService:StateListService,private _addressTypeList:AddressTypeList,
    private _cirPurposeList:CirPurposeList, private _reportTypeList:ReportTypeList,private _appService:AppService,private router: Router,fb: FormBuilder,fb1: FormBuilder,private _routeParams: ActivatedRoute)
    {

        //console.log("request id from input page::::"+this._initalizeData.getRequestId());
      //  console.log("_createEnq:::: "+this._createEnq.reqId);

    //   this._appService.getRequestId().subscribe((reqId) => {                   
    //           console.log("reqID"+reqId)           ;
    //         });
    
        _newService.consumerCompVar$.subscribe(
            consumerValidate => {
                console.log("inputforEnquiry _appService.consumerCompVar$.subscribe consumerValidate --->  " + consumerValidate);
                this.consumerValid = consumerValidate;
        });
         /*_newService.missionConfirmed$.subscribe(
      astronaut => {
          console.log("Astronot---->"+astronaut);
       // this.history.push(`${astronaut} confirmed the mission`);
      });*/

        // _initalizeData.createEnqCompVar$.subscribe(
        //     requestId =>{
        //         this.requestId = requestId;
        //         console.log("this.requestId"+this.requestId);
        //     }
        // );
            _routeParams.queryParams.subscribe(params => {this.issOnlyBIR = params['isOnlyBir'] || 'false',this.isCombo = params['isCombo'] || 'false',this.isCir = params['isCir'] || 'false',this.requestId = params['reqId'] || '0'});
            this.birVal = this.issOnlyBIR + ""; 
            this.cirVal = this.isCir + "";
            this.comboVal = this.isCombo + "";
            if(this.birVal == "true")
            {
                console.log("this.issOnlyBIR If"+this.issOnlyBIR);
                this.issOnlyBIR = true;
            } 
            else
            {
                console.log("this.issOnlyBIR else"+this.issOnlyBIR);
                this.issOnlyBIR = false;
            }
            if(this.cirVal == "true")
            {
                console.log("this.cirVal If"+this.isCir);
                this.isCir = true;
            } 
            else
            {
                console.log("this.cirVal else"+this.isCir);
                this.isCir = false;
            }
            if(this.comboVal == "true")
            {
                console.log("this.issOnlyBIR If"+this.isCombo);
                this.isCombo = true;
            } 
            else
            {
                console.log("this.issOnlyBIR else"+this.isCombo);
                this.isCombo = false;
            }
  // console.log("Inside constructtor..."+this.consumerObj.requisitionForm.valid);
         this.submitted=false;
         this.cirForm= fb.group(
         {          
          'pincode'     : [null,  Validators.compose([Validators.required,Validators.pattern('[0-9]{6}')])],
          'email'       : [null,  Validators.compose([Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$'),Validators.required])],
          //'pan'         : [null,  Validators.compose([Validators.pattern('([A-Za-z]{3})([PFCAHBLJRpfcahbljr]{1})([0-9]{4})([A-Za-z]{1})'),Validators.required])],
          //'cmppan'      : [null,  Validators.compose([Validators.pattern('([A-Za-z]{3})([PFCAHBLJRpfcahbljr]{1})([0-9]{4})([A-Za-z]{1})'),Validators.required])],
          //'pan'         : [null,  Validators.compose([Validators.pattern('([A-Za-z]{3})([ABCFGHLJPTKabcfghljptk]{2})([0-9]{4})([A-Za-z]{1})'),Validators.required])],
          'cmppan'      : [null,  Validators.compose([Validators.pattern('([A-Za-z]{3})[ABCFEGHLJPTabcfeghljpt][A-Za-z]([0-9]{4})([A-Za-z]{1})'),Validators.required])],
          'city'        : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'product'     : [null,  Validators.required],
          'address'     : [null,  Validators.required],         
          'cirPurpose'  : [null,  Validators.required],
          'cirState'    : [null,  Validators.required]
         });
         
         this.birForm =fb.group(
         {
          'companyName' :[null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z0-9&]*')])],          
          'cmplist'     :[null,  Validators.required]
        });
        this.cirForm2 =fb1.group(
         {
          //'personpan'   : [null,  Validators.compose([Validators.pattern('([A-Za-z]{3})([PFCAHBLJRpfcahbljr]{1})([0-9]{4})([A-Za-z]{1})'),Validators.required])],
          'personPin'   : [null,  Validators.compose([Validators.required,Validators.pattern('[0-9]{6}')])],
          'mobile'      : [null,  Validators.compose([Validators.required,Validators.pattern('[0-9]{10}')])],
          'fname'       : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
         // 'mname'       : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'lname'       : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],         
          'personCity'  : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'personAddr'  : [null,  Validators.required],
          'personState' : [null,  Validators.required],
          //'birthDate'   : [null,  Validators.required],
          'gender'      : [null,  Validators.required]
             });
   }

    back()
    {
        this.submitted=false;
        this.controlMessage.getValidator(this.submitted);
       this.router.navigate(['createEnquiry'],{queryParams: {reqId: EirCreateComponent.reqId}});
      //  this.router.navigate(['createEnquiry']);
    }

    onChange(newValue) {
             console.log("Inside Onchange method........"+newValue);
             this.commonArray.cir.companyName = newValue.entityName;
             console.log("Inside Onchange method commonArray.bir.companyName........"+this.commonArray.cir.companyName);
    }
  
    validate()
    {
         console.log("request id from input page::::"+EirCreateComponent.reqId);
       // debugger;
  // console.log("request id from input page::::"+this._dataService.getRequestId());
        var isValidationComplete : boolean = true ;
	
        this._newService.inquerySubmitClick(true);
       
        console.log(" in validate consumerValid ----> " + this.consumerValid);
            this.commonArray.requestId  = EirCreateComponent.reqId;          
            this.submitted=true;
            this.controlMessage.getValidator(this.submitted);

             
            this.commonArray.isBIRActive = this.birVal;
            this.commonArray.isCIRActive = this.cirVal;
            this.commonArray.isComboActive = this.comboVal;
            
            if(this.commonArray.isBIRActive == 'false')
            {
                this.commonArray.bir = null;
            }

            if(this.commonArray.isComboActive == 'false' )
            {
                this.commonArray.consumerList = null;
                if(this.commonArray.isCIRActive == 'false')
                {
                    this.commonArray.cir = null;
                }
            }

            if(this.commonArray.isCIRActive == 'false' && this.commonArray.isComboActive == 'false' )
            {
                    this.commonArray.cir = null;
            }

            

           
        if(this.issOnlyBIR && !this.birForm.valid )
        {
            isValidationComplete = false;
            
        }
         

        if(this.isCir && !this.cirForm.valid)
        {
                isValidationComplete = false;
                
        }


        if(this.isCombo && !this.consumerValid && !this.cirForm.valid)
        {
            isValidationComplete = false;
        }

		 if(isValidationComplete)
		 {    
            // debugger;
            alert("Data Submitted Successfully!!!");
			 this._appService.createEnquiry(this.commonArray).subscribe((data) =>{
                    this.data = data;  
                    console.log("data"+data)
                    console.log("inside sub method..........."+this.data);
                    this.navigate();
                    console.log("inside end...........");
             });		
		 }
         else
         {
             alert("Fill all the mandatory fields!!!");
         }
    }

     navigate(){
        console.log("inside navigate method...........");
        this.router.navigate(['viewEnquiryComponent'],{queryParams: { requestId: EirCreateComponent.reqId}});
     }

    getCompanyList()
    {   
        console.log("commonArray.bir.companyName---------"+this.commonArray.bir.companyName)
            this._cmpname.validateName(this.commonArray.bir ).subscribe((temp) => {
            
            this.company=temp;
            this.jsonResponse = JSON.stringify(temp);

            if(temp!=null)
            {
            this.hasList=true;
            }
            });        
    }
}
