import { Component } from '@angular/core';
import { Router} from '@angular/router';
import { HomeComponent } from './component/eir.home';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./css/bootstrap.css',
               './css/bootstrap.min.css',
               './css/bootstrap-theme.css',
               './css/bootstrap-theme.min.css',
               './css/carousel.css',
               './css/dashboard.css'],
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
