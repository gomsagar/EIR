import { Component,Input } from '@angular/core';
import { Router} from '@angular/router';
import {HttpModule, Http} from "@angular/http";
import{CompanyListService} from '../services/eir.companyList';
import{CompanyNameService} from '../services/eir.sendCompName';
import{FormGroup,FormBuilder, Validators} from '@angular/forms';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import {ValidationResult} from '../services/eir.validation';
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
               providers: [HttpModule,CompanyListService,CompanyNameService,FormsModule,ReactiveFormsModule]
})
export class InputForEnquiryComponent 
{
    private _subscription;
    private jsonResponse: string;
    private messagess: Array<MessageJson>;
    data = <any>{};
    compList=<any>[];   
     temp = <any>[{"Cin":"U70109WB1992PTC054090","Name":"LNT PVT LTD."}, {
    "Cin": "U45201KA2008PTC048000",
    "Name": "LNT PROMOTERS PRIVATE LIMITED"
  }];
    private hasList:boolean=false;
    complexForm : FormGroup;
    
    constructor(private _cmpservice:CompanyListService,private _cmpname:CompanyNameService,private router: Router,fb: FormBuilder){
   /* this._subscription = this._cmpservice.getData()
             .subscribe(
                 (checkboxValue) => {
                     console.log("Inside init method"+ checkboxValue);
                     this.jsonResponse = JSON.stringify(checkboxValue);
                     
                     console.log("Message data......"+this.messagess); 
                     console.log("Json response:"+this.jsonResponse);     

                this.isCws= checkboxValue.comboWithScore;
                this.isCwos= checkboxValue.comboWithoutScore ;
                this.isCIRws= checkboxValue.commWithScore ;
                this.isCIRwos= checkboxValue.commWithoutScore ;
                this.isSME= checkboxValue.sme ;
                this.isBIR= checkboxValue.bir ;
                this.isnf= checkboxValue.newsFeed ;
                this.isld= checkboxValue.litigation ;
                 },
                 (err) => console.log(err),
                 () => console.log('hello service test complete')
         );    */
         this.complexForm = fb.group({
          'firstName' : [null, Validators.required]
          })

         
   }

   getCompanyList(){
   
  // alert(this.data.cmpName);
     console.log("Hello......... from getCompanyList function");
     console.log("Company Name:"+this.data.cmpName);
    

     this._cmpname.validateName(this.data).subscribe((temp) => {
        // debugger;
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
