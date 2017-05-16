import { Component,Input } from '@angular/core';
import { Router} from '@angular/router';
import {HttpModule, Http} from "@angular/http";
import{CompanyListService} from '../services/eir.companyList';
import{CompanyNameService} from '../services/eir.sendCompName';

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
               providers: [HttpModule,CompanyListService,CompanyNameService]
})
export class InputForEnquiryComponent 
{
    private _subscription;
    private jsonResponse: string;
    private messagess: Array<MessageJson>;
    data = <any>{};
    temp = <any>{};
    constructor(private _cmpservice:CompanyListService,private _cmpname:CompanyNameService,private router: Router){
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
   }

   getCompanyList(){alert(this.data.cmpName);
     console.log("Hello......... from getCompanyList function");
     console.log("Company Name:"+this.data.cmpName);
    
     this._cmpname.validateName(this.data).subscribe((temp) => {
         debugger;
         console.log("responce   -  - "+ temp);
         this.jsonResponse = JSON.stringify(temp);
         console.log('json srijfkd -- '+this.jsonResponse);
         console.log('name - '+temp.name);
         });
     // this.router.navigate(['inputForEnquiry']);
   }
  
}
