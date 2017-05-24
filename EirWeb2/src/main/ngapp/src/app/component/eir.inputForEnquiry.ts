import { Component,Input } from '@angular/core';
import { Router,ActivatedRoute} from '@angular/router';
import {HttpModule, Http} from "@angular/http";
import{CompanyListService} from '../services/eir.companyList';
import{CompanyNameService} from '../services/eir.sendCompName';
import{FormGroup,FormBuilder,FormControl, Validators} from '@angular/forms';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import{AppService} from '../services/eir.callController';
import{EirCreateComponent} from './eir.createEnquiry';
import { DatePickerOptions, DateModel } from 'ng2-datepicker';

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
 providers: [HttpModule,CompanyListService,AppService,CompanyNameService,FormsModule,ReactiveFormsModule]
})
export class InputForEnquiryComponent 
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
    temp = <any>[];
    private hasList:boolean=false;
    complexForm : FormGroup;
    complexForm1 : FormGroup;
    complexForm2: FormGroup;
    formValid:boolean=false;
  
    constructor(private _cmpservice:CompanyListService,private _cmpname:CompanyNameService,
    private _appService:AppService,private router: Router,fb: FormBuilder,fb1: FormBuilder,private _routeParams: ActivatedRoute)
    {
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
   
         this.submitted=false;
         this.complexForm= fb.group(
         {          
          'pincode'     : [null,  Validators.compose([Validators.required,Validators.pattern('[0-9]{6}')])],
          'email'       : [null,  Validators.compose([Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$'),Validators.required])],
          'pan'         : [null,  Validators.compose([Validators.pattern('([A-Za-z]{3})([PFCAHBLJRpfcahbljr]{1})([0-9]{4})([A-Za-z]{1})'),Validators.required])],
          'cmppan'      : [null,  Validators.compose([Validators.pattern('([A-Za-z]{3})([PFCAHBLJRpfcahbljr]{1})([0-9]{4})([A-Za-z]{1})'),Validators.required])],
          'city'        : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'product'     : [null,  Validators.required],
          'address'     : [null,  Validators.required],         
          'purpose'     : [null,  Validators.required],
          'accType'     : [null,  Validators.required],
          'accType1'    : [null,  Validators.required],
          'state'       : [null,  Validators.required]
         });
         this.complexForm1 =fb.group(
         {
          'compName'    :[null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z0-9&]*')])],          
          'cmplist'     :[null,  Validators.required]
        });
        this.complexForm2 =fb1.group(
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
        this.router.navigate(['createEnquiry']);
    }
  
    validate()
    {
            this.submitted=true;
            console.log("this.complexForm.valid"+this.complexForm.valid);
            console.log("this.complexForm1.valid"+this.complexForm1.valid);
            console.log("this.complexForm2.valid"+this.complexForm2.valid);
            //this.validForm=this.complexForm1.valid + "";
         
           if(this.issOnlyBIR && this.isCombo)
           {
                if(this.complexForm1.valid && this.complexForm.valid && this.complexForm2.valid)
                {
                    this._appService.submitInfo(this.data).subscribe(this.data);
                    alert("Data Submitted Successfully!!!");
                    this.router.navigate(['inputForEnquiry']);
                }
                else
                {
                    alert("Fill all the mandatory fields!!!");
                }
           }
           else if(this.issOnlyBIR && this.isCir)
           {
                if(this.complexForm1.valid && this.complexForm.valid)
                {
                    this._appService.submitInfo(this.data).subscribe(this.data);
                    alert("Data Submitted Successfully!!!");
                    this.router.navigate(['inputForEnquiry']);
                }
                else
                {
                    alert("Fill all the mandatory fields!!!");
                }
           }
            else if(this.issOnlyBIR )
           {
                if(this.complexForm1.valid)
                {
                this._appService.submitInfo(this.data).subscribe(this.data);
                alert("Data Submitted Successfully!!!");
                this.router.navigate(['inputForEnquiry']);
                }
                else
                {
                alert("Fill all the mandatory fields!!!");
                }
           }
    }

    getCompanyList()
    {
            this._cmpname.validateName(this.data).subscribe((temp) => {
            
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
