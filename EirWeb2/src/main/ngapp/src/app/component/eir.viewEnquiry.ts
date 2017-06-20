import { Component,Input } from '@angular/core';
import { Router} from '@angular/router';

@Component({
  selector: 'viewEnquiryComponent',
  templateUrl: '../html/ViewEnquiry.html'
})
export class ViewEnquiryComponent 
{
    constructor(private router: Router){
    
  }
   back()
    {
        this.router.navigate(['home']);
    }
}
