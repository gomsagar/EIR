import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './component/eir.home';
import { InputForEnquiryComponent } from './component/eir.inputForEnquiry';
import{EirCreateComponent} from './component/eir.createEnquiry';
import{RaiseDisputeComponent} from './component/eir.raiseDispute';
import{ViewEarlierRequestComponent} from './component/eir.viewEarlierRequest';
import{TrackDisputeComponent} from  './component/eit.trackDispute';




const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
   { path: 'createEnquiry', component: EirCreateComponent },
    { path: 'inputForEnquiry', component: InputForEnquiryComponent },
    { path: 'raiseDispute', component: RaiseDisputeComponent },
    { path: 'viewEarlierRequest', component: ViewEarlierRequestComponent },
     { path: 'trackDispute', component: TrackDisputeComponent},
     
];
@NgModule({
  declarations: [AppComponent,HomeComponent,EirCreateComponent,InputForEnquiryComponent,RaiseDisputeComponent,
  ViewEarlierRequestComponent,TrackDisputeComponent],
  imports: [
    RouterModule,
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [RouterModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
