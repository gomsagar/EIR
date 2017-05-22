import { FormControl } from '@angular/forms';

export class ValidationResult {
 [key:string]:boolean;

 static startsWithNumber(control: FormControl){ 
 
   if ( control.value !="" && !isNaN(control.value)){
     return { "startsWithNumber": true };
   }
}
static emailValidator(control: FormControl) {
        // RFC 2822 compliant regex
        if (control.value.match(/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/)) {
            return null;
        } else {
            return { 'invalidEmailAddress': true };
        }
 }
}