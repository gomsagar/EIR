import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes,ActivatedRoute } from '@angular/router';
import { ReactiveFormsModule  } from '@angular/forms'
import { AppComponent } from './app.component';
import { HomeComponent } from './component/eir.home';
import { InputForEnquiryComponent } from './component/eir.inputForEnquiry';
import{EirCreateComponent} from './component/eir.createEnquiry';
import{RaiseDisputeComponent} from './component/eir.raiseDispute';
import{ViewEarlierRequestComponent} from './component/eir.viewEarlierRequest';
import{TrackDisputeComponent} from  './component/eit.trackDispute';
import{ConsumerComponent} from './component/eir.consumer';
import {ControlMessages} from './services/control.message.component';
import { DatePickerModule } from 'ng2-datepicker';

const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
   { path: 'createEnquiry', component: EirCreateComponent },
    { path: 'inputForEnquiry', component: InputForEnquiryComponent },
    { path: 'raiseDispute', component: RaiseDisputeComponent },
    { path: 'viewEarlierRequest', component: ViewEarlierRequestComponent },
     { path: 'trackDispute', component: TrackDisputeComponent},
     { path: 'consumerComponent', component: ConsumerComponent},
     
];
@NgModule({
  declarations: [AppComponent,HomeComponent,EirCreateComponent,InputForEnquiryComponent,RaiseDisputeComponent,
  ViewEarlierRequestComponent,TrackDisputeComponent,ConsumerComponent,ControlMessages],
  imports: [
    RouterModule,
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
     DatePickerModule
  ],
  providers: [RouterModule,ReactiveFormsModule],
    bootstrap: [AppComponent]
})
export class AppModule { }
