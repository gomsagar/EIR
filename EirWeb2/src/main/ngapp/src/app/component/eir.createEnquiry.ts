import { Component,Inject,Input,OnInit,Injectable} from '@angular/core';
import {HttpModule, Http} from "@angular/http";
import{AppService} from '../services/eir.callController';
import{DataService} from '../services/eir.getData';
import {Router,ActivatedRoute} from '@angular/router';
import { InputForEnquiryComponent } from './eir.inputForEnquiry';
import { InitalizeService } from '../services/eir.initalizeData';
import { LoaderService } from '../services/eir.loader';
interface MessageJson {
    cws: boolean;
    cwos: boolean;
}

@Component({
 selector: 'createEnquiry',
 templateUrl: '../html/createEnquiry.html',
  providers: [HttpModule,AppService,DataService,InitalizeService],
  styleUrls: ['../app.component.css']
})

export class EirCreateComponent implements OnInit {
private _subscription;
  private jsonResponse: string;
  private messagess: Array<MessageJson>;
  public loggedInUserFlagVar: string;
   private route: ActivatedRoute;
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
  existingData = <any>{};
  public isOnlyBir:boolean;
  public isCir:boolean;
  public isCombo:boolean;
  @Input() checkboxValue =<any>{};
public static reqId : number;
 public requestId:number;
 public sendRequestId:number;
 showLoader:boolean;

  constructor(private _appService:AppService,private _routeParams: ActivatedRoute,private _dataService:DataService,private loaderService: LoaderService,private router: Router,private _initalizeData :  InitalizeService)
  {
    //debugger;
   this.showLoader=true;
   this.data.comboWithoutScore=false;
   this.data.comboWithScore=false;
   this.data.commWithScore=false;
   this.data.commWithoutScore=false;
   this.data.sme=false;
   this.data.bir=false;
   this.data.newsFeed=false;
   this.data.litigation=false;

   this.value.comboWithoutScore=0;
   this.value.comboWithScore=0;
   this.value.commWithScore=0;
   this.value.commWithoutScore=0;
   this.value.sme=0;
   this.value.bir=0;
   this.value.newsFeed=0;
   this.value.litigation=0;
   this.loaderService.display(true);
   this.loaderService.status.subscribe((val: boolean) => {
            this.showLoader = val;

        });
    _routeParams.queryParams.subscribe(params => {this.requestId = params['reqId'] || 0 }); 

     console.log("Inside init method"+ this.requestId+" Loader:"+this.showLoader);
     
      console.log(" Loader:"+this.showLoader);
    if(this.requestId == 0)
    {
      this.sendRequestId = 0;
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
               this.loaderService.display(false);  
                },
                (err) => console.log(err),
                () => console.log('hello service test complete')
        );    
       // this.value = this.data;
    }
    else
    {
      this.sendRequestId = this.requestId;
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

               this._dataService. getSelectedProduct(this.requestId)
            .subscribe((checkboxValue) => {
               
                this.existingData = checkboxValue;

                if(checkboxValue.comboWithoutScore == 1)
                {
                  this.data.comboWithoutScore = true;
                }
                if(checkboxValue.comboWithScore == 1)
                {
                  this.data.comboWithScore = true;
                }
                if(checkboxValue.commWithoutScore == 1)
                {
                  this.data.commWithoutScore = true;
                }
                if(checkboxValue.commWithScore == 1)
                {
                  this.data.commWithScore = true;
                }
                if(checkboxValue.bir == 1)
                {
                  this.data.bir = true;
                }
                if(checkboxValue.newsFeed == 1)
                {
                  this.data.newsFeed = true;
                }
                if(checkboxValue.sme == 1)
                {
                  this.data.sme = true;
                }
                if(checkboxValue.litigation == 1)
                {
                  this.data.litigation = true;
                }

                console.log('Reverse data'+ this.data.bir)

             } );
              this.loaderService.display(false); 
                },
                (err) => console.log(err),
                () => console.log('hello service test complete')

                
        );    
        //this.value = this.data;

           
    }
    //this.loaderService.display(false);  
         console.log(" Loader:"+this.showLoader);
         
  }

  ngOnInit(){
    //debugger;
    this.loaderService.status.subscribe((val: boolean) => {
            this.showLoader = val;
        });
  

    this._dataService.getUserFlag().subscribe((loggedInUserFlag) => {            
            console.log("loggedInUserFlag -  - "+ loggedInUserFlag.memberType);
           this.loggedInUserFlagVar = loggedInUserFlag.memberType;   
            console.log("this.loggedInUserFlagVar -  - "+ this.loggedInUserFlagVar);         
        });  


  }

  back()
  {
    this.router.navigate(['home']);
  }
  selectedCheckBox()
  { 
      console.log("Hello......... from function");
      if(this.data.comboWithoutScore)
      {
        this.value.comboWithoutScore = 1;
      }
      if(this.data.comboWithScore)
      {
        this.value.comboWithScore = 1;
      }
      if(this.data.commWithoutScore)
      {
        this.value.commWithoutScore = 1;
      }
      if(this.data.commWithScore)
      {
        this.value.commWithScore = 1;
      }
      if(this.data.bir)
      {
        this.value.bir = 1;
      }
      if(this.data.newsFeed)
      {
        this.value.newsFeed = 1;
      }
      if(this.data.sme)
      {
        this.value.sme = 1;
      }
      if(this.data.litigation)
      {
        this.value.litigation = 1;
      }
      
      this.value.comboWithScore    = this.setData(this.existingData.comboWithScore,this.value.comboWithScore);
      this.value.comboWithoutScore = this.setData(this.existingData.comboWithoutScore, this.value.comboWithoutScore);
      this.value.commWithScore     = this.setData(this.existingData.commWithScore, this.value.commWithScore);
      this.value.commWithoutScore  = this.setData(this.existingData.commWithoutScore, this.value.commWithoutScore);
      this.value.sme               = this.setData(this.existingData.sme, this.value.sme);
      this.value.bir               = this.setData(this.existingData.bir, this.value.bir);
      this.value.newsFeed          = this.setData(this.existingData.newsFeed, this.value.newsFeed);
      this.value.litigation        = this.setData(this.existingData.litigation,this.value.litigation);

       console.log("this.value.bir :"+this.value.bir );

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
       
        //debugger;
          this._appService.submit(this.value,this.sendRequestId).subscribe((reqId) => {
              EirCreateComponent.reqId=reqId;     
              console.log("reqID"+EirCreateComponent.reqId);
              
            });
          console.log("reqID outside:"+EirCreateComponent.reqId);
         //console.log("_subscription:"+this._subscription.)

          // if(this.loggedInUserFlagVar == 'NON-SPECIFIED')
          // {            
          //   this.router.navigate(['kycComponent'],{ queryParams: { isOnlyBir: this.isOnlyBir, isCombo: this.isCombo, isCir: this.isCir} });
          // }else {
          //     this.router.navigate(['inputForEnquiry'],{queryParams: { isOnlyBir: this.isOnlyBir, isCombo: this.isCombo, isCir: this.isCir}});
          // }
//debugger;
        
         this.router.navigate(['inputForEnquiry'],{queryParams: { isOnlyBir: this.isOnlyBir, isCombo: this.isCombo, isCir: this.isCir, reqId: EirCreateComponent.reqId}});
    }
    else
    {
        alert("Please select Product !!!");
        this.router.navigate(['createEnquiry']);
    }
  }

  setSelectedValue(existingVlaue, selectedValue)
  {

      
  }

  setData(existingVlaue, selectedValue)
  {
    if(existingVlaue == selectedValue)
        {
            return 2;
        }
        else 
        {
            return selectedValue
        }
  }
}
