import { Component } from '@angular/core';
import { Router} from '@angular/router';
import { HomeComponent } from './component/eir.home';
import { FileUploader } from 'ng2-file-upload';

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

  goToViewRequest(){
    this.router.navigate(['viewEarlierRequest']);
  }

  goToTrackDisput(){

  }

  goToRaiseDisput(){
    
  }
  goToDashboard()
  {
    this.router.navigate(['home']);
  }
}
