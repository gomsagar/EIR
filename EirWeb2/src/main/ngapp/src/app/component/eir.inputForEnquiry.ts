import { Component,Input } from '@angular/core';
import { Router,ActivatedRoute} from '@angular/router';
import {HttpModule, Http} from "@angular/http";
import{CompanyListService} from '../services/eir.companyList';
import{CompanyNameService} from '../services/eir.sendCompName';
import{FormGroup,FormBuilder, Validators} from '@angular/forms';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import{AppService} from '../services/eir.callController';
import{EirCreateComponent} from './eir.createEnquiry';

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
export class InputForEnquiryComponent {
    
    public fb1: FormBuilder;
    private _subscription;
    private jsonResponse: string;
    private birVal: string;
    private messagess: Array<MessageJson>;
    submitted:boolean;
    public issOnlyBIR:boolean;
    private route: ActivatedRoute;
    data = <any>{};
    value = <any>{};
    info= <any>{};
    compList=<any>[];   
     temp = <any>[{"Cin":"U70109WB1992PTC054090","Name":"LNT PVT LTD."}, {
    "Cin": "U45201KA2008PTC048000",
    "Name": "LNT PROMOTERS PRIVATE LIMITED"
  }];
    private hasList:boolean=false;
    complexForm : FormGroup;
  
  
    constructor(private _cmpservice:CompanyListService,private _cmpname:CompanyNameService,
    private _appService:AppService,private router: Router,fb: FormBuilder,private _routeParams: ActivatedRoute)
    {
   
            _routeParams.queryParams.subscribe(params => {this.issOnlyBIR = params['isOnlyBir'] || 'false'});
            this.birVal = this.issOnlyBIR + ""; 
            console.log("constructor this.birVal --> " + this.birVal);
        if(this.birVal == "true")
            {
                console.log("constructor if");
                console.log("in if isOnlyBIR --> " + this.issOnlyBIR);
                this.issOnlyBIR = true;
            } 
            else{
                console.log("constructor else");
                this.issOnlyBIR = false;
            }
            console.log("after route --> " + this.issOnlyBIR);
            
   
         this.submitted=false;
         this.complexForm = fb.group(
         {
          'compName'    : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z0-9&]*')])],
          'pincode'     : [null,  Validators.compose([Validators.required, Validators.minLength(6), Validators.maxLength(6),Validators.pattern('^[0-9]*$')])],
          'email'       : [null,  Validators.compose([Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$'),Validators.required])],
          'pan'         : [null,  Validators.compose([Validators.pattern('([A-Za-z]{3})([PFCAHBLJRpfcahbljr]{1})([0-9]{4})([A-Za-z]{1})'),Validators.required])],
          'cmppan'      : [null,  Validators.compose([Validators.pattern('([A-Za-z]{3})([PFCAHBLJRpfcahbljr]{1})([0-9]{4})([A-Za-z]{1})'),Validators.required])],
          'personpan'   : [null,  Validators.compose([Validators.pattern('([A-Za-z]{3})([PFCAHBLJRpfcahbljr]{1})([0-9]{4})([A-Za-z]{1})'),Validators.required])],
          'personPin'   : [null,  Validators.compose([Validators.required,Validators.pattern('[0-9]{6}')])],
          'mobile'      : [null,  Validators.compose([Validators.required,Validators.pattern('[0-9]{10}')])],
          'fname'       : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'mname'       : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'lname'       : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'dob'         : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'personCity'  : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'city'        : [null,  Validators.compose([Validators.required,Validators.pattern('[A-Za-z]*')])],
          'product'     : [null,  Validators.required],
          'address'     : [null,  Validators.required],
          'personAddr'  : [null,  Validators.required],
          'cmplist'     : [null,  Validators.required],
          'purpose'     : [null,  Validators.required],
          'accType'     : [null,  Validators.required],
          'accType1'    : [null,  Validators.required],
          'personState' : [null,  Validators.required],
          'state'       : [null,  Validators.required],
          'gender'      : [null,  Validators.required]
          
})
   }

   back(){
       this.router.navigate(['createEnquiry']);
   }
  
  validate(){
      alert("Hello");
   this.submitted=true;
   console.log("Data............"+this.data);
   this._appService.submitInfo(this.data).subscribe(this.data);
     this.router.navigate(['inputForEnquiry']);
}
getCompanyList(){
  
     console.log("Hello......... from getCompanyList function");
     console.log("Company Name:"+this.data.cmpName);
    

         this._cmpname.validateName(this.data).subscribe((temp) => {
        
         this.compList=temp;
         console.log("responce   -  - "+ temp);
         this.jsonResponse = JSON.stringify(temp);
         console.log('json srijfkd -- '+this.jsonResponse);
         console.log('name - '+temp[0].Name);
          if(temp!=null)
         {
         this.hasList=true;
         console.log('this.hasList......'+this.hasList);
         }
         });
    
   }
  
}
