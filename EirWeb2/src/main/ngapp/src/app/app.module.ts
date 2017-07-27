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
import{ViewEnquiryComponent} from './component/eir.viewEnquiry';
import{TrackDisputeComponent} from  './component/eit.trackDispute';
import{ConsumerComponent} from './component/eir.consumer';
import {ControlMessages} from './services/control.message.component';
import { DatePickerModule } from 'ng2-datepicker';
import { KycComponent } from './component/eir.KycComponent';
import { APP_CONFIG, AppConfig } from './app.config';
import { LoaderService } from './services/eir.loader';
import { MyDatePickerModule } from 'mydatepicker';
import {CrmAdmin} from './component/eir.crmAdmin';
import {CrmAdminApproval} from './component/eir.CrmAdminApproval';
import { PagerService } from './services/pager.service';
const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
   { path: 'createEnquiry', component: EirCreateComponent },
    { path: 'inputForEnquiry', component: InputForEnquiryComponent },
    { path: 'raiseDispute', component: RaiseDisputeComponent },
    { path: 'viewEarlierRequest', component: ViewEarlierRequestComponent },
     { path: 'trackDispute', component: TrackDisputeComponent},
     { path: 'consumerComponent', component: ConsumerComponent},
     { path: 'viewEnquiryComponent', component: ViewEnquiryComponent},
     { path: 'kycComponent', component: KycComponent},
     { path: 'crmAdmin', component: CrmAdmin},
     { path: 'crmAdminApproval', component: CrmAdminApproval},
];
@NgModule({
  declarations: [AppComponent,HomeComponent,EirCreateComponent,InputForEnquiryComponent,RaiseDisputeComponent,
  ViewEarlierRequestComponent,TrackDisputeComponent,ConsumerComponent,ControlMessages,KycComponent,ViewEnquiryComponent,
  CrmAdmin,CrmAdminApproval],
  imports: [
    RouterModule,
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    MyDatePickerModule,
     DatePickerModule
  ],
  providers: [RouterModule,LoaderService,ReactiveFormsModule,PagerService,{ provide: APP_CONFIG, useValue: AppConfig }],
    bootstrap: [AppComponent]
})
export class AppModule { }
