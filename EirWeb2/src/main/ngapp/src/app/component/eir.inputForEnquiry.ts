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

//import{}

interface MessageJson {
    name:string;
    cin:string;
}

@Component({
  selector: 'inputForEnquiry',
  templateUrl: '../html/inputForEnquiry.html',
  styleUrls: ['../css/bootstrap.css',
               '../css/bootstrap.min.css',
               '../css/bootstrap-theme.css',
               '../css/bootstrap-theme.min.css',
               '../css/carousel.css',
               '../css/dashboard.css'],
 providers: [HttpModule,CompanyListService,AppService,CompanyNameService,StateListService,AddressTypeList,CirPurposeList,FormsModule,ReactiveFormsModule,NewService,ControlMessages,ReportTypeList]
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
    data = <any>{};
    value = <any>{};
    info= <any>{};
    compList=<any>[];
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

    commonArray: any = {
        isBIRActive:'',
        isCIRActive:'',
        isComboActive:'',
         bir: {companyName:'',cmpList:''},
        cir: {companyName:'',productField:'',purpose:'',amt:'',accType1:'',clientRefNo:'',accType2:'',cmpPan:'',addrType:'',addrLinen1:'',
              addrline2:'',city:'',state:'',pinCode:'',telephoneNo:'',pan:'',cin:'',tin:'',emailId:'',triggers:''},
        consumerList: [ 
                {relationType:'',accountType:'',firstName:'',middleName:'',lastName:'',personPan:'',drivingLic:'',aadharhCard:'',voterId:'',
                rationCard:'',passportNo:'',homeTelephoneNo:'',officeTelephoneNo:'',mobileNo:'',birthDate:'',maritalStatus:'',gender:'',
                personAddrLine1:'',personAddrLine2:'',personCity:'',personState:'',personPincode:'',amount:''}                
            ]
};

consumerData : any= [{relationType:'',accountType:'',firstName:'',middleName:'',lastName:'',personPan:'',drivingLic:'',aadharhCard:'',voterId:'',
                rationCard:'',passportNo:'',homeTelephoneNo:'',officeTelephoneNo:'',mobileNo:'',birthDate:'',maritalStatus:'',gender:'',
                personAddrLine1:'',personAddrLine2:'',personCity:'',personState:'',personPincode:'',amount:''}]  ;

  ngOnInit(){
    this._stateListService.getStateList().subscribe((stateListSubs) => {

           this.stateList=stateListSubs;

            console.log("responce   -  - "+ stateListSubs);
            this.jsonResponse = JSON.stringify(stateListSubs);
            //console.log('json srijfkd -- '+this.jsonResponse);
            //console.log('name - '+temp[0].Name);
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
      
    constructor(private _cmpservice:CompanyListService,private _cmpname:CompanyNameService,private _newService :NewService,private controlMessage:ControlMessages,private _stateListService:StateListService,private _addressTypeList:AddressTypeList,
    private _cirPurposeList:CirPurposeList, private _reportTypeList:ReportTypeList,private _appService:AppService,private router: Router,fb: FormBuilder,fb1: FormBuilder,private _routeParams: ActivatedRoute)
    {

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

        
            _routeParams.queryParams.subscribe(params => {this.issOnlyBIR = params['isOnlyBir'] || 'false',this.isCombo = params['isCombo'] || 'false',this.isCir = params['isCir'] || 'false'});
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
          'pan'         : [null,  Validators.compose([Validators.pattern('([A-Za-z]{3})([PFCAHBLJRpfcahbljr]{1})([0-9]{4})([A-Za-z]{1})'),Validators.required])],
          'cmppan'      : [null,  Validators.compose([Validators.pattern('([A-Za-z]{3})([PFCAHBLJRpfcahbljr]{1})([0-9]{4})([A-Za-z]{1})'),Validators.required])],
          'city'        : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'product'     : [null,  Validators.required],
          'address'     : [null,  Validators.required],         
          'purpose'     : [null,  Validators.required],
          'state'       : [null,  Validators.required]
         });
         this.birForm =fb.group(
         {
          'compName'    :[null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z0-9&]*')])],          
          'cmplist'     :[null,  Validators.required]
        });
        this.cirForm2 =fb1.group(
         {
          //'personpan'   : [null,  Validators.compose([Validators.pattern('([A-Za-z]{3})([PFCAHBLJRpfcahbljr]{1})([0-9]{4})([A-Za-z]{1})'),Validators.required])],
          'personPin'   : [null,  Validators.compose([Validators.required,Validators.pattern('[0-9]{6}')])],
          'mobile'      : [null,  Validators.compose([Validators.required,Validators.pattern('[0-9]{10}')])],
          'fname'       : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'mname'       : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'lname'       : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],         
          'personCity'  : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'personAddr'  : [null,  Validators.required],
          'personState' : [null,  Validators.required],
          //'dob'       : [null,  Validators.required],
          'gender'      : [null,  Validators.required]
             });
   }

    back()
    {
        this.submitted=false;
        this.controlMessage.getValidator(this.submitted);
        this.router.navigate(['createEnquiry']);
    }

    onChange(newValue) {
             console.log("Inside Onchange method........"+newValue);
             this.commonArray.cir.companyName = newValue;
             console.log("Inside Onchange method commonArray.bir.companyName........"+this.commonArray.cir.companyName);
    }
  
    validate()
    {
        //debugger;
        this._newService.inquerySubmitClick(true);
       
        console.log(" in validate consumerValid ----> " + this.consumerValid);
            
            
            this.submitted=true;
            this.controlMessage.getValidator(this.submitted);
            //this.controlMessage.getValidator(this.submitted);
           // console.log("Inside validate ConsumerComponent.consumerVal..."+ConsumerComponent.consumerVal);
            console.log("this.cirForm.valid"+this.cirForm.valid);
            console.log("this.cirForm1.valid"+this.birForm.valid);
            console.log("this.cirForm2.valid"+this.cirForm2.valid);
            //this.validForm=this.cirForm1.valid + "";
         console.log("CIR:"+this.commonArray.cir.cmpName);
         console.log("BIR:"+this.commonArray.bir);
         console.log("Consumer:"+this.commonArray.consumer);
         
         debugger;
         if(this.issOnlyBIR){
                if(this.birForm.valid )
                {
                    debugger;
                    this.commonArray.isBIRActive = this.birVal;
                    this.commonArray.isCIRActive = this.cirVal;
                    this.commonArray.isComboActive = this.comboVal;
                    this._appService.submitInfo(this.commonArray).subscribe(this.data);
                    alert("Data Submitted Successfully!!!");
                    //this.router.navigate(['inputForEnquiry']);
                }
                else
                {
                    alert("Fill all the mandatory fields!!!");
                }
         }

          if(this.isCir || this.isCombo){
                if(this.cirForm.valid && this.consumerValid)
                { 
                    debugger;
                    this.commonArray.isBIRActive = this.birVal;
                    this.commonArray.isCIRActive = this.cirVal;
                    this.commonArray.isComboActive = this.comboVal;
                    console.log('this.birVal ========= '+this.birVal +'  this.cirVal ============ '+this.cirVal+'   this.comboVal ======'+this.comboVal);
                    this._appService.submitInfo(this.commonArray).subscribe(this.data);
                    alert("Data Submitted Successfully!!!");
                    //this.router.navigate(['inputForEnquiry']);
                }
                else
                {
                    alert("Fill all the mandatory fields!!!");
                }
         }

         
    }

    getCompanyList()
    {   debugger;
        console.log("commonArray.bir.companyName---------"+this.commonArray.bir.companyName)
            this._cmpname.validateName(this.commonArray.bir ).subscribe((temp) => {
            
            this.compList=temp;
            //console.log("responce   -  - "+ temp);
            this.jsonResponse = JSON.stringify(temp);
            //console.log('json srijfkd -- '+this.jsonResponse);
            //console.log('name - '+temp[0].Name);
            if(temp!=null)
            {
            this.hasList=true;
            }
            });        
    }
}
