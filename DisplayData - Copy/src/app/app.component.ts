import { Component, ViewEncapsulation } from '@angular/core';
import { HelloService } from './app.service';


interface MessageJson {
    title: string;
    message: string;
}

@Component({
    selector: 'spring-boot-angular2',
    template:'<h2>Data</h2><div ><p>{{data}}</p> </div>',
   // styleUrls: ['app.component.css'],
  //  encapsulation: ViewEncapsulation.None,
    providers: [HelloService]
})
export class AppComponent {
    private jsonResponse: string;
    private messages: Array<MessageJson>;
    private _subscription;
    data : JsonData[];

    // constructor
    constructor(private _helloService: HelloService) {}

    // on-init
    ngOnInit() {
        // save _subscription
        this._subscription = this._helloService.getTest().subscribe(
                (data) => {
                     //debugger;
                    this.data = data;

                    this.jsonResponse = JSON.stringify(data);
                    this.messages = data;
                    console.log('Json data from == '+data+'  jsonResponse == '+this.jsonResponse);
                },
                (err) => console.log('eror here !!!!!!!!!!!!!!!! = '+err),
                () => console.log('hello service test complete')
        );
    }

    // on-destroy
    ngOnDestroy() {
        // unsubscribe
        this._subscription.unsubscribe();
    }

    
}
interface JsonData{
      //  id:number;
      //  title:string;
     //   body : string;
        name:string;

    }