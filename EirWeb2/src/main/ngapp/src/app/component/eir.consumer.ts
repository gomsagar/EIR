import { Component,Input,OnDestroy,OnInit } from '@angular/core';
import {Observable} from 'rxjs/Rx';
import{AppService} from '../services/eir.callController';
import{FormGroup,FormBuilder,FormControl, Validators} from '@angular/forms';
import {ControlMessages} from '../services/control.message.component';
import { Subscription }   from 'rxjs/Subscription';
import{AccountTyprList} from '../services/dropdown/eir.getAccntTypeList';
import{RelationTypeList} from '../services/dropdown/eir.getRelationTypeList';
import{ConsumerPurposeList} from '../services/dropdown/eir.getConsumerPurposeList';
//import{ControlGroup} from '@angular/common';
import{NewService} from '../services/eir.newService';
import { DatePickerOptions, DateModel } from 'ng2-datepicker';
@Component({
  selector: 'consumerComponent',
  templateUrl: '../html/consumer.html',
  styleUrls: ['../css/bootstrap.css',
               '../css/bootstrap.min.css',
               '../css/bootstrap-theme.css',
               '../css/bootstrap-theme.min.css',
               '../css/carousel.css',
               '../css/dashboard.css'],
providers:[AppService,AccountTyprList,RelationTypeList,ConsumerPurposeList]
})

export class ConsumerComponent implements OnDestroy, OnInit {
 private list: number[] = [];
 private hasList:boolean=false;
 private jsonResponse: string;
 data =<any> {};
 accntTypeList = <any>[];
 relationTypeList = <any>[];
form:FormControl; 
requisitionForm: FormGroup; 
consumerPurposeList=<any>[];
static iRow: number = 1;
isConsumerValid : boolean = false;
subscription: Subscription;
submitted : boolean;
  options: DatePickerOptions;
  @Input() consumerData = [
    {relationType:'',accountType:'',firstName:'',middleName:'',lastName:'',personPan:'',drivingLic:'',aadharhCard:'',voterId:'',
                rationCard:'',passportNo:'',homeTelephoneNo:'',officeTelephoneNo:'',mobileNo:'',birthDate:'',maritalStatus:'',gender:'',
                personAddrLine1:'',personAddrLine2:'',personCity:'',personState:'',personPincode:'',amount:''} 
 ];

 constructor(public fb1: FormBuilder, private _appService:AppService, private _newService:NewService, private _accntTypeList:AccountTyprList, private _relationTypeList:RelationTypeList,
  private _consumerPurposeList:ConsumerPurposeList) {
 /* this.subscription = _newService.missionAnnounced$.subscribe(
      mission => {
          console.log("AstronautComponent missionService.missionAnnounced$.subscribe ");
       console.log("mission-----"+mission);
    });

/*debugger;*/
this.options = new DatePickerOptions();
  this.subscription =  _newService.inqueryCompVar$.subscribe(
            inqueryCompVar => {
this.isConsumerValid = inqueryCompVar;
this.submitted = true;
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
      this._accntTypeList.getAccnTypeList().subscribe((accntType) => {
        this.accntTypeList=accntType;
        this.jsonResponse = JSON.stringify(accntType);
        if(accntType!=null)
            {
            this.hasList=true;
            }
    });
    this._relationTypeList.getRelationTypeList().subscribe((relationType) => {
        debugger;
        this.relationTypeList=relationType;
        this.jsonResponse = JSON.stringify(relationType);
        if(relationType!=null)
            {
            this.hasList=true;
            }
    });
    this._consumerPurposeList.getConsumerPurposeList().subscribe((consumerPurpose) => {
        debugger;
        this.consumerPurposeList=consumerPurpose;
        this.jsonResponse = JSON.stringify(consumerPurpose);
        if(consumerPurpose!=null)
            {
            this.hasList=true;
            }
    });
   }

 rowValidateForm(i: number, scenario?: string) {
  
  // console.log("Inside row validator........."+this.submitted);
  		let action = "addControl";
  		if (scenario == 'remove') {
  			action = "removeControl";
  		} 
  		this.requisitionForm[action]('firstName' + i, new FormControl('', [Validators.required,Validators.pattern('[A-Za-z]*')]));
      this.requisitionForm[action]('middleName' + i, new FormControl('', [Validators.required,Validators.pattern('[A-Za-z]*')]));
      this.requisitionForm[action]('lastName' + i, new FormControl('', [Validators.required,Validators.pattern('[A-Za-z]*')]));
      this.requisitionForm[action]('mobileNo' + i, new FormControl('', [Validators.required,Validators.pattern('[0-9]{10}')]));
      this.requisitionForm[action]('gender' + i, new FormControl('', [Validators.required,Validators.pattern('[A-Za-z]*')]));
      this.requisitionForm[action]('personAddrLine1' + i, new FormControl('', [Validators.required]));
      this.requisitionForm[action]('personAddrLine2' + i, new FormControl('', [Validators.required]));
      this.requisitionForm[action]('personCity' + i, new FormControl('', [Validators.required,Validators.pattern('[A-Za-z]*')]));
      this.requisitionForm[action]('personState' + i, new FormControl('', [Validators.required]));
      this.requisitionForm[action]('personPinCode' + i, new FormControl('', [Validators.required,Validators.pattern('[0-9]{6}')]));
  	}

 addMore(){
   this.consumerData.push({
     relationType:'',accountType:'',firstName:'',middleName:'',lastName:'',personPan:'',drivingLic:'',aadharhCard:'',voterId:'',
                rationCard:'',passportNo:'',homeTelephoneNo:'',officeTelephoneNo:'',mobileNo:'',birthDate:'',maritalStatus:'',gender:'',
                personAddrLine1:'',personAddrLine2:'',personCity:'',personState:'',personPincode:'',amount:''
   })
   
    this.rowValidateForm(ConsumerComponent.iRow++, 'add');
 }

 remove(){
   if(ConsumerComponent.iRow != 1){
     this.consumerData.pop();
      ConsumerComponent.iRow--;
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

}