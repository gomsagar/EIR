import { Injectable } from '@angular/core';
import { Subject }    from 'rxjs/Subject';

@Injectable()
export class InitalizeService {

// Observable boolean sources
   inqueryCompVar = new Subject<number>();
   createEnqCompVar = new Subject<number>();

  // Observable boolean streams
  inqueryCompVar$ = this.inqueryCompVar.asObservable();
  createEnqCompVar$ = this.createEnqCompVar.asObservable();

    EnquryRequestId(requestId:number){

         this.inqueryCompVar.next(requestId);
    }

    CreateEnqRequestId(requestId:number){
        
        this.createEnqCompVar.next(requestId);
    }
}