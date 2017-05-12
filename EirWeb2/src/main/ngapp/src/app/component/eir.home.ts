import { Component,Input } from '@angular/core';
import { Router} from '@angular/router';

@Component({
  selector: 'home',
  templateUrl: '../html/home.html',
   styleUrls: ['../css/bootstrap.css',
               '../css/bootstrap.min.css',
               '../css/bootstrap-theme.css',
               '../css/bootstrap-theme.min.css',
               '../css/carousel.css',
               '../css/dashboard.css'],
})
export class HomeComponent 
{
 
  constructor(private router: Router) 
  {
    console.log("HomeComponent");   
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
