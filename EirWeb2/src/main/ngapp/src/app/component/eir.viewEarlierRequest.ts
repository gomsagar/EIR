import { Component,Input } from '@angular/core';
import { Router} from '@angular/router';

@Component({
  selector: 'viewEarlierRequest',
  templateUrl: '../html/viewEarlierRequest.html'
})
export class ViewEarlierRequestComponent 
{
  constructor(private router: Router){
    
  }
   back()
    {
        this.router.navigate(['home']);
    }
  
  submit()
  {
    console.log("Inside submit method.....");
    this.router.navigate(['viewEnquiryComponent']);
  }
}
