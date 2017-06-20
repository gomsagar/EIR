import { Component,Inject,Input,OnInit} from '@angular/core';
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
  providers: [HttpModule,AppService,DataService]
})

export class EirCreateComponent implements OnInit {
private _subscription;
  private jsonResponse: string;
  private messagess: Array<MessageJson>;
  public loggedInUserFlagVar: string;
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

  ngOnInit(){
    this._dataService.getUserFlag().subscribe((loggedInUserFlag) => {            
            console.log("loggedInUserFlag -  - "+ loggedInUserFlag);
            this.loggedInUserFlagVar = loggedInUserFlag.userFlag;            
        });  
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

        //   if(this.loggedInUserFlagVar == 'NonSpecifiedUser')
        //   {            
        //     this.router.navigate(['kycComponent'],{ queryParams: { isOnlyBir: this.isOnlyBir, isCombo: this.isCombo, isCir: this.isCir} });
        //   }else {
        //       this.router.navigate(['inputForEnquiry'],{queryParams: { isOnlyBir: this.isOnlyBir, isCombo: this.isCombo, isCir: this.isCir}});
        //   }

         this.router.navigate(['inputForEnquiry'],{queryParams: { isOnlyBir: this.isOnlyBir, isCombo: this.isCombo, isCir: this.isCir}});
    }
    else
    {
        alert("Select Product!!!");
        this.router.navigate(['createEnquiry']);
    }
  }
}
