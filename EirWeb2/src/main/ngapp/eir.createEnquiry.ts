import { Component,Inject,Input} from '@angular/core';
import {HttpModule, Http} from "@angular/http";
import{AppService} from '../services/eir.callController';
import{DataService} from '../services/eir.getData';
import {Router} from '@angular/router';
import { InputForEnquiryComponent } from './eir.inputForEnquiry';

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
  value = <any>{};
  data = <any>{};
  public isOnlyBir:boolean;
  public isCir:boolean;
  public isCombo:boolean;
  @Input() checkboxValue =<any>{};


  constructor(private _appService:AppService,private _dataService:DataService,private router: Router)
  {
   this.data.comboWithoutScore=false;
   this.data.comboWithScore=false;
   this.data.commWithScore=false;
   this.data.commWithoutScore=false;
   this.data.sme=false;
   this.data.bir=false;
   this.data.newsFeed=false;
   this.data.litigation=false;

   this._subscription = this._dataService.getData()
            .subscribe((checkboxValue) => {
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
        this.value = this.data;
  }
  back()
  {
    this.router.navigate(['home']);
  }
  selectedCheckBox()
  { 
      console.log("Hello......... from function");
      if(this.data.comboWithoutScore || this.data.commWithoutScore || this.data.newsFeed ||
        this.data.comboWithScore ||  this.data.commWithScore || this.data.litigation || this.data.sme || this.data.bir)
      {
        //  if(this.data.bir && !(this.data.comboWithoutScore || this.data.commWithoutScore || this.data.newsFeed ||
        //  this.data.comboWithScore ||  this.data.commWithScore || this.data.litigation || this.data.sme))
        if(this.data.bir)
          {
              this.isOnlyBir = true;
              console.log("Only bir:"+this.isOnlyBir);
          }
          if(this.data.comboWithoutScore || this.data.comboWithScore)
          {
              this.isCombo = true;
              console.log("Only Combo:"+this.isCombo);
          }
          if(this.data.commWithoutScore ||  this.data.commWithScore)
          {
              this.isCir = true;
              console.log("Only Cir:"+this.isCir);
          }
          this._appService.submit(this.data).subscribe(this.data);
          if(this.isOnlyBir && this.isCombo)
          {
            this.router.navigate(['inputForEnquiry'],{ queryParams: { isOnlyBir: true, isCombo: true, isCir: false} });
          }
          else if(this.isOnlyBir && this.isCir)
          {
            this.router.navigate(['inputForEnquiry'],{ queryParams: { isOnlyBir: true, isCir: true, isCombo: false} });
          }
          else if(this.isOnlyBir)
          {
            this.router.navigate(['inputForEnquiry'],{ queryParams: { isOnlyBir: true, isCir: false, isCombo: false} });
          }
          else if(this.isCir)
          {
            this.router.navigate(['inputForEnquiry'],{ queryParams: { isOnlyBir: false, isCir: true, isCombo: false} });
          }
          else if(this.isCombo)
          {
            this.router.navigate(['inputForEnquiry'],{ queryParams: { isOnlyBir: false, isCir: false, isCombo:true } });
          }
    }
    else
    {
        alert("Select Product!!!");
        this.router.navigate(['createEnquiry']);
    }
  }
}
