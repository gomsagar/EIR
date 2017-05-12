import { Component,Inject,Input} from '@angular/core';
import {HttpModule, Http} from "@angular/http";
import{AppService} from '../services/eir.callController';
import{DataService} from '../services/eir.getData';
import {Router} from '@angular/router';

interface MessageJson {
    cws: boolean;
    cwos: boolean;
}

@Component({
 selector: 'createEnquiry',
 templateUrl: '../html/createEnquiry.html',
 styleUrls: ['../css/bootstrap.css',
               '../css/bootstrap.min.css',
               '../css/bootstrap-theme.css',
               '../css/bootstrap-theme.min.css',
               '../css/carousel.css',
               '../css/dashboard.css'],

  providers: [HttpModule,AppService,DataService]
})


export class EirCreateComponent {
private _subscription;
  private jsonResponse: string;
  private messagess: Array<MessageJson>;
  isCws:boolean; 
  isCwos:boolean;
  isCIRws:boolean;
  isCIRwos:boolean;
  isSME:boolean;
  isBIR:boolean;
  isnf:boolean;
  isld:boolean;

  data = <any>{};
  @Input() checkboxValue =<any>{};
  constructor(private _appService:AppService,private _dataService:DataService,private router: Router){

   this.data.cwos=false;
   this.data.cws=false;
   this.data.CIRws=false;
   this.data.CIRwos=false;
   this.data.SME=false;
   this.data.BIR=false;
   this.data.nf=false;
   this.data.ld=false;

   this._subscription = this._dataService.getData()
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
        );    
  }

  selectedCheckBox(){
    console.log("Hello......... from function");
    console.log("CWS:"+this.data.cws);
    console.log("CWOS:"+this.data.cwos);
    this._appService.submit(this.data).subscribe(this.data);
     this.router.navigate(['inputForEnquiry']);
  }
}
