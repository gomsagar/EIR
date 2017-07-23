import { Component,Input } from '@angular/core';
import { Router} from '@angular/router';
import{DataService} from '../services/eir.getData';
import{CompanyNameService} from '../services/eir.sendCompName';
import { LoaderService } from '../services/eir.loader';

interface MessageJson {}
@Component({
  selector: 'home',
  templateUrl: '../html/home.html',
  providers: [CompanyNameService],
  styleUrls: ['../app.component.css']
})
export class HomeComponent 
{
 private _subscription;
 private jsonResponse: string;
 private messagess: Array<MessageJson>;
 private totEnq;
 private inProcessEnq;
 private pendingDisp;
 private totDisp;
 userId:Number;
 showLoader:boolean;

  constructor(private router: Router,private loaderService: LoaderService,private _compService:CompanyNameService) 
  {
    this.userId=1;
    console.log("HomeComponent");   
   this.loaderService.display(true);
   this.loaderService.status.subscribe((val: boolean) => {
            this.showLoader = val;

        });
     this._subscription = this._compService.getCount(this.userId)
            .subscribe((count) => {
                    
                    this.jsonResponse = JSON.stringify(count);
                    
                    console.log("Message data......"+this.messagess); 
                    console.log("Json response:"+this.jsonResponse);     

               this.totEnq = count.totEnquiry;
               this.inProcessEnq = count.inProcessEnquiry;
               this.pendingDisp = count.pendingDispute;
               this.totDisp = count.totDispute;
               this.loaderService.display(false);
                },
                (err) => console.log(err),
                () => console.log('hello service test complete')
        );    
  }
   goToCreateEnquiry()
  {
    console.log("goToCreateEnquiry()");
    this.router.navigate(['createEnquiry']);
  }
  goToViewRequest()
  {
    console.log("goToViewRequest()");
    this.router.navigate(['viewEnquiryComponent']);
  }
  goToRaiseDispute()
  {
    console.log("goToRaiseDispute()");
    this.router.navigate(['raiseDispute']);
  }
  goToTrackDispute()
  {
    console.log("goToTrackDispute()");
    this.router.navigate(['trackDispute']);
  }
}
