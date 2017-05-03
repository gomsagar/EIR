import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HelloService } from './app.service';
//import { HelloComponent } from './hello/hello.component';

@NgModule({
  declarations: [
    AppComponent 
    
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [HelloService],
  bootstrap: [AppComponent]
})
export class AppModule { }
