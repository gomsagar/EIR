import { Component,Input,OnDestroy,OnInit } from '@angular/core';
import {Observable} from 'rxjs/Rx';
import{AppService} from '../services/eir.callController';
import{FormGroup,FormBuilder,FormControl, Validators} from '@angular/forms';
import {ControlMessages} from '../services/control.message.component';
import { Subscription }   from 'rxjs/Subscription';
import{AccountTyprList} from '../services/dropdown/eir.getAccntTypeList';
import{RelationTypeList} from '../services/dropdown/eir.getRelationTypeList';
import{ConsumerPurposeList} from '../services/dropdown/eir.getConsumerPurposeList';
import{StateListService} from '../services/eir.stateList';
import{AddressTypeList} from '../services/eir.getAddressTypeList';
import {Moment} from 'moment';
import * as moment from 'moment';
import { LoaderService } from '../services/eir.loader';

//import{ControlGroup} from '@angular/common';
import{NewService} from '../services/eir.newService';
import { DatePickerOptions, DateModel } from 'ng2-datepicker';
import {MyDatePicker,IMyDpOptions,IMyDate} from 'mydatepicker';

@Component({
  selector: 'consumerComponent',
  templateUrl: '../html/consumer.html',
  styleUrls: ['../app.component.css'],
providers:[AppService,AccountTyprList,RelationTypeList,ConsumerPurposeList,AddressTypeList]
})

export class ConsumerComponent implements OnDestroy, OnInit {
  dt1 : Date;
  miniDate:Date;
 private list: number[] = [];
 private hasList:boolean=false;
 private jsonResponse: string;
 private counter : number=1;
 data =<any> {};
 accntTypeList = <any>[];
 relationTypeList = <any>[];
form:FormControl; 
requisitionForm: FormGroup; 
consumerPurposeList=<any>[];
consumerAddrTypeList=<any>[];
consumerFinancialPurposeList=<any>[];
static iRow: number = 1;
isvalid: boolean = false;
isValidPan: boolean = false;
isLastDigitPin: boolean = false;
isValidData: boolean = false;
isValidDataPin: boolean = false;
isConsumerValid : boolean = false;
isValidAdhar: boolean = false;
isValidDL: boolean = false;
isValidAdharL: boolean = false;
isValidPass: boolean = false;
isValidRation: boolean = false;
isValidVoter: boolean = false;
isValidMob: boolean = false;
isValidHtel: boolean = false;
isValidOtel: boolean = false;
subscription: Subscription;
submitted : boolean;
stateList=<any>[];
genderList=<any>[];
frequencyList=<any>[];
public dateExpires: any; 
showLoader1:boolean;
 d = new Date();
 year = this.d.getFullYear();
 month = this.d.getMonth();
day = this.d.getDate();
mind:String;
//options: DatePickerOptions;
private myDatePickerOptions: IMyDpOptions = {
        // other options...
        showInputField:true,
        minYear:this.year-100,
        maxYear:this.year,
        disableSince: { year: this.year, month: this.month+1, day: this.day },
        dateFormat: 'yyyy-mm-dd',
        editableDateField:false
    };
private selDate: IMyDate = {year: 0, month: 0, day: 0};

  @Input() consumerData = [
    {relationType:'',accountType:'',firstName:'',middleName:'',lastName:'',personPan:'',drivingLic:'',aadharhCard:'',voterId:'',
                rationCard:'',passportNo:'',homeTelephoneNo:'',officeTelephoneNo:'',mobileNo:'',birthDate:'',maritalStatus:'',gender:'',
               addressType :'' , personAddrLine1:'',personAddrLine2:'',personCity:'',personState:'',personPinCode:'',amount:'',consumerPurpose:'',consumerFinancialPurpose:'',frequency:'',durationOfAgreement:''} 
 ];

 constructor(public fb1: FormBuilder, private _appService:AppService, private _newService:NewService, private _accntTypeList:AccountTyprList, private _relationTypeList:RelationTypeList,
  private _consumerPurposeList:ConsumerPurposeList,private loaderService: LoaderService, private _stateListService:StateListService , private _consumerAddrTypeList:AddressTypeList) {
 /* this.subscription = _newService.missionAnnounced$.subscribe(
      mission => {
          console.log("AstronautComponent missionService.missionAnnounced$.subscribe ");
       console.log("mission-----"+mission);
    });

*/
this.loaderService.display(true);
   this.loaderService.status.subscribe((val: boolean) => {
            this.showLoader1 = val;

        });
//this.options = new DatePickerOptions();
  this.subscription =  _newService.inqueryCompVar$.subscribe(
            inqueryCompVar => {
this.isConsumerValid = inqueryCompVar;
this.submitted = true;

// this.pinValidate(ConsumerComponent.iRow);
 // this.groupValidate(ConsumerComponent.iRow);

 console.log("Inside row validator........."+this.submitted);
console.log("consumer _appService.inqueryCompVar$.subscribe inqueryCompVar --->  " + inqueryCompVar);
              if(this.requisitionForm.valid ){
                  this._newService.consumerValidateCalled(true);
                  console.log("consumer _appService.inqueryCompVar$.subscribe in if " );
              }
              else{
                this._newService.consumerValidateCalled(false);
                console.log("consumer _appService.inqueryCompVar$.subscribe inqueryCompVar in else");
              }
        });
   this.requisitionForm = this.fb1.group({});
    this.rowValidateForm(0);
    
   
            // this._newService.confirmMission("true");
            this._newService.consumerValidateCalled(true);
   }  
   ngOnInit(){

     //this.stateList = this._newService.getStateList();
     this.dt1 = new Date();
      this.dateExpires = this.dt1;
      this.miniDate = new Date(this.year -100, this.month, this.day);
      this.mind=this.miniDate.toString();
      this._stateListService.getStateList().subscribe((stateListSubs) => {

           this.stateList=stateListSubs;
           // this._newService.setStateList(stateListSubs);
            console.log("responce   -  - "+ stateListSubs);
            this.jsonResponse = JSON.stringify(stateListSubs);
            //console.log('json srijfkd -- '+this.jsonResponse);
            //console.log('name - '+temp[0].Name);
            if(stateListSubs!=null)
            {
            this.hasList=true;
          }
          this.loaderService.display(false);
        });  

        this._consumerPurposeList.getFrequency().subscribe((frequency) => {
        this.frequencyList=frequency;
        this._newService.setfrequency(frequency);
            console.log("responce   -  - "+ frequency);
            this.jsonResponse = JSON.stringify(frequency);
            if(frequency!=null)
            {
            this.hasList=true;
            }
    });

      this._accntTypeList.getAccnTypeList().subscribe((accntType) => {
        this.accntTypeList=accntType;
        this.jsonResponse = JSON.stringify(accntType);
        if(accntType!=null)
            {
            this.hasList=true;
            }
    });
    this._relationTypeList.getRelationTypeList().subscribe((relationType) => {
        this.relationTypeList=relationType;
        this.jsonResponse = JSON.stringify(relationType);
        if(relationType!=null)
            {
            this.hasList=true;
            }
    });
    this._consumerPurposeList.getConsumerPurposeList().subscribe((consumerPurpose) => {
        this.consumerPurposeList=consumerPurpose;
        this.jsonResponse = JSON.stringify(consumerPurpose);
        if(consumerPurpose!=null)
            {
            this.hasList=true;
            }
    });
     this._consumerAddrTypeList.getAddressTypeList().subscribe((addressType) => {
        this.consumerAddrTypeList=addressType;
        this.jsonResponse = JSON.stringify(addressType);
        if(addressType!=null)
            {
            this.hasList=true;
            }
    });

    this._consumerPurposeList.getGender().subscribe((genders) => {
        this.genderList=genders;
    });

    

  }

   rowValidateForm(i: number, scenario?: string) {

  		let action = "addControl";
  		if (scenario == 'remove') {
  			action = "removeControl";
  		} 
  		this.requisitionForm[action]('firstName' + i, new FormControl('', [Validators.required,Validators.pattern('[A-Za-z ]*'),Validators.maxLength(26)]));
      this.requisitionForm[action]('middleName' + i, new FormControl('', [Validators.pattern('[A-Za-z ]*'),Validators.maxLength(26)]));
      this.requisitionForm[action]('lastName' + i, new FormControl('', [Validators.required,Validators.pattern('[A-Za-z ]*'),Validators.maxLength(26)]));
      this.requisitionForm[action]('mobileNo' + i, new FormControl('', [Validators.required,Validators.pattern('[0-9]{10}')]));
      this.requisitionForm[action]('gender' + i, new FormControl('', [Validators.required]));
      this.requisitionForm[action]('birthDate' + i, new FormControl('', [Validators.required]));
      this.requisitionForm[action]('personAddrLine1' + i, new FormControl('', [Validators.required,Validators.maxLength(40) ]));
   //   this.requisitionForm[action]('personAddrLine2' + i, new FormControl('', [Validators.required]));
      this.requisitionForm[action]('personCity' + i, new FormControl('', [Validators.required,Validators.pattern('[A-Za-z]*')]));
     // this.requisitionForm[action]('personPan' + i, new FormControl('', [Validators.required,Validators.pattern('([A-Za-z]{3})[ABCFEGHLJPTabcfeghljpt][A-Za-z]([0-9]{4})([A-Za-z]{1})')]));
      this.requisitionForm[action]('personState' + i, new FormControl('', [Validators.required]));
      this.requisitionForm[action]('personPinCode' + i, new FormControl('', [Validators.required,Validators.pattern('(?!.*000$)[1-9][0-9]{5}')]));
      this.requisitionForm[action]('consumerPurpose' + i, new FormControl('', [Validators.required]));
      this.requisitionForm[action]('consumerFinancialPurpose' + i, new FormControl('', [Validators.required]));
      this.requisitionForm[action]('amount' + i, new FormControl('', [Validators.required,Validators.pattern('[0-9]{1,9}')]));
      this.requisitionForm[action]('terms' + i, new FormControl('', [Validators.required,Validators.pattern('[0-9]{1,2}')]));
      this.requisitionForm[action]('frequency' + i, new FormControl('', [Validators.required]));
       this.requisitionForm[action]('accountType' + i, new FormControl('', [Validators.required]));
      this.requisitionForm[action]('status' + i, new FormControl('', [Validators.pattern('[A-Za-z]*'),Validators.maxLength(26)]));
  	}

 addMore(){
   if(ConsumerComponent.iRow < 15){
      this.consumerData.push({
        relationType:'',accountType:'',firstName:'',middleName:'',lastName:'',personPan:'',drivingLic:'',aadharhCard:'',voterId:'',
                    rationCard:'',passportNo:'',homeTelephoneNo:'',officeTelephoneNo:'',mobileNo:'',birthDate:'',maritalStatus:'',gender:'',
                    addressType :'' , personAddrLine1:'',personAddrLine2:'',personCity:'',personState:'',personPinCode:'',amount:'',
                    consumerPurpose:'', consumerFinancialPurpose:'',frequency:'',durationOfAgreement:''})
      
        this.rowValidateForm(ConsumerComponent.iRow++, 'add');
        
   }
   else{
     alert("Cannot add more than 15 Consumers!!!");
   }
 }

 remove(){
   if(ConsumerComponent.iRow != 1){
     this.consumerData.pop();
      ConsumerComponent.iRow--;
   }
   else{
     alert("Must include atleast one consumer!!!");
   }
 }

 pinValidate(num: number)
 {
console.log("Validation:" + this.consumerData[num].personPinCode )
 if(this.consumerData[num].personPinCode == '')
 {
   this.isvalid = true;
 }
 if(this.consumerData[num].personPinCode.length != 6)
 {
  this.isValidData = true;

 }
 if(this.consumerData[num].personPinCode.startsWith('0'))
 {
  this.isValidDataPin = true;
 }
 if(this.consumerData[num].personPinCode.includes('0',3) &&
 this.consumerData[num].personPinCode.includes('0',4) && this.consumerData[num].personPinCode.includes('0',5))
 {
  this.isLastDigitPin = true;
 }
 }
 
 groupValidate(num: number)
 {
//console.log("Validation:" + this.consumerData[num].personPinCode )
 this.isValidPan = false;
 this.isValidDL = false;
 this.isValidAdhar = false;
 this.isValidAdharL = false; 
 this.isValidPass = false;
 this.isValidRation = false;
 this.isValidHtel = false;
 this.isValidMob = false; 
 this.isValidOtel = false;
 
if(this.consumerData[num].personPan != '')
{
  if(this.consumerData[num].personPan.match('([A-Za-z]{3})[ABCFEGHLJPTabcfeghljpt][A-Za-z]([0-9]{4})([A-Za-z]{1})'))
  {
    this.isValidPan = false;
  }
  else
  {
    this.isValidPan = true;
  //  this.requisitionForm.valid=false;
  }
 }
 else if(this.consumerData[num].drivingLic != '' )
 {
  if(this.consumerData[num].drivingLic.match("[a-zA-Z0-9 ]{10}"))
  {
    this.isValidDL = false;
  }
  else
  {
    this.isValidDL = true;
  //  this.requisitionForm.valid=false;
  }

 }
 else if(this.consumerData[num].aadharhCard != '' )
 {
   if(this.consumerData[num].aadharhCard.startsWith('0'))
   {
    this.isValidAdhar = true;
    //this.requisitionForm.valid=false;
   }
  else  if(this.consumerData[num].aadharhCard.length != 12)
  {
    this.isValidAdharL = true;
   // this.requisitionForm.valid=false;
  }
  else
  {
    this.isValidAdhar = false;
    this.isValidAdharL = false;
  }
 }
 else if(this.consumerData[num].passportNo != '' )
 {
   if(this.consumerData[num].passportNo.match("[a-zA-Z][0-9]{7}"))
   {
    this.isValidPass = false;
   }
  else
  {
    this.isValidPass = true;
   // this.requisitionForm.valid=false;
  }
 }
 else if(this.consumerData[num].rationCard != '' )
 {
   if(this.consumerData[num].rationCard.match("[a-zA-Z0-9 ]{10}"))
   {
    this.isValidRation = false;
   }
  else
  {
    this.isValidRation = true;
    //this.requisitionForm.valid=false;
  }
 }
 else if(this.consumerData[num].voterId != '' )
 {
   if(this.consumerData[num].voterId.match("[a-zA-Z0-9 ]{10}"))
   {
    this.isValidVoter = false;
   }
  else
  {
    this.isValidVoter = true;
   // this.requisitionForm.valid=false;
  }
 }
 else if(this.consumerData[num].mobileNo != '' )
 {
   if(this.consumerData[num].mobileNo.match("[7-9][0-9]{9}"))
   {
    this.isValidMob = false;
   }
  else
  {
    this.isValidMob = true;
   // this.requisitionForm.valid=false;
  }
 }
 else if(this.consumerData[num].homeTelephoneNo != '' )
 {
   if(this.consumerData[num].homeTelephoneNo.match("[0-9]{5,}"))
   {
    this.isValidHtel = false;
   }
  else
  {
    this.isValidHtel = true;
    //this.requisitionForm.valid=false;
  }
 }
 else if(this.consumerData[num].officeTelephoneNo != '' )
 {
   if(this.consumerData[num].officeTelephoneNo.match("[0-9]{5,}"))
   {
    this.isValidOtel = false;
   }
  else
  {
    this.isValidOtel = true;
    //this.requisitionForm.valid=false;
  }
 }
 else
 {
   alert("Input Error -  At least one of Telephone Number, Mobile Number, PAN, Passport Number,AAdhar,Driving License Number or Voter ID card is required '");
  // this.requisitionForm.valid = false;
  
 }
 
 }
   /* ngOnInit(){
      this.counter().subscribe(
        data => {
          console.log("Inside ngOnInIt this.list.length --> " + this.list.length);
          console.log("Inside ngOnInIt before if this.list --> " + this.list);
          console.log("Inside ngOnInIt AppService.count --> " + AppService.count);
          if(this.list.length != AppService.count - 1){
              for(var i=this.list.length;i < AppService.count -1 ; i++){
              this.list[i] = AppService.count;            
            }
            console.log("Inside ngOnInIt after if this.list --> " + this.list);
          }
        })
    };
    
    
  counter() {
    
    return Observable
        .interval(500)
        .map(() => {
            return AppService.count;
        });
  }*/

   ngOnDestroy() {
    // prevent memory leak when component destroyed
    this.subscription.unsubscribe();
  }

  getFinancialPurpose(purposeIdObj)
  {
    this.loaderService.display(true);
    if(purposeIdObj)
    {
      this._consumerPurposeList.getConsumerFinancialPurposeList(purposeIdObj.purposeId).subscribe((financialPurposeListResponse) => {
          this.consumerFinancialPurposeList = financialPurposeListResponse;
        // this.jsonResponse = JSON.stringify(financialPurposeListResponse);
          if(financialPurposeListResponse!=null)
          {
          this.hasList=true;
        }
        this.loaderService.display(false);
      });
    }
  }

}