import { Component,Input } from '@angular/core';
import { Router} from '@angular/router';
import{DataService} from '../services/eir.getData';
interface MessageJson {}
@Component({
  selector: 'home',
  templateUrl: '../html/home.html',
  providers: [DataService]
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


  constructor(private router: Router,private _dataService:DataService) 
  {
    console.log("HomeComponent");   
     this._subscription = this._dataService.getCount()
            .subscribe((count) => {
                    
                    this.jsonResponse = JSON.stringify(count);
                    
                    console.log("Message data......"+this.messagess); 
                    console.log("Json response:"+this.jsonResponse);     

               this.totEnq = count.totEnquiry;
               this.inProcessEnq = count.inProcessEnquiry;
               this.pendingDisp = count.pendingDispute;
               this.totDisp = count.totDispute;
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
    this.router.navigate(['viewEarlierRequest']);
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
