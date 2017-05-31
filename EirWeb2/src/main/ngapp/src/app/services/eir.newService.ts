 import { Injectable } from '@angular/core';
import { Subject }    from 'rxjs/Subject';

@Injectable()
export class NewService {
 
 // Observable boolean sources
   inqueryCompVar = new Subject<boolean>();
   consumerCompVar = new Subject<boolean>();

  // Observable boolean streams
  inqueryCompVar$ = this.inqueryCompVar.asObservable();
  consumerCompVar$ = this.consumerCompVar.asObservable();

  // Service message commands
  inquerySubmitClick(submit: boolean) {
      console.log("AppService inquerySubmitClick submit ---> " + submit);
    this.inqueryCompVar.next(submit);
  }

  consumerValidateCalled(consumerValidate: boolean) {
       console.log("AppService consumerValidateCalled submit ---> " + consumerValidate);
    this.consumerCompVar.next(consumerValidate);
  }
}