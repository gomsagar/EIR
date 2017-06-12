import { Component } from '@angular/core';
import { Router} from '@angular/router';
import { HomeComponent } from './component/eir.home';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  constructor(private router: Router) 
  {
    this.router.navigate(['home']);
  }

 goToCreateEnquiry()
  {
    console.log("goToCreateEnquiry()");
    this.router.navigate(['createEnquiry']);
  }
}
