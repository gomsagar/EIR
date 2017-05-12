import { Component } from '@angular/core';
import { Router} from '@angular/router';
import { HomeComponent } from './component/eir.home';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private router: Router) 
  {
    console.log("HOmepage");
    this.router.navigate(['home']);
  }

}
