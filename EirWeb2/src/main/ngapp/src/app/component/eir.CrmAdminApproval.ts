import { Component,Input,ViewChild } from '@angular/core';
import {Router,ActivatedRoute} from '@angular/router';
import{AppService} from '../services/eir.callController';

@Component({
  selector: 'kycComponent',
  templateUrl: '../html/CrmAdminApproval.html',
  providers: [AppService],
  //styleUrls: ['../app.component.css']
})

export class CrmAdminApproval 
{
    ngOnInit(){
       // this._appService.getViewRequest(this.requestId).subscribe((viewRequestData) =>{ 

   // });
    }
    constructor(private router: Router,private _routeParams: ActivatedRoute,private _appService:AppService){

    }
    back(){
        console.log("inside back method");
        this.router.navigate(['crmAdmin']);
    }

    kycApprove(){
        console.log("inside kyc approval method");
    }

    kycReject(){
        console.log("inside kyc reject method");
    }
}