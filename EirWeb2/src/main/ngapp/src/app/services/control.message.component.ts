import { Component, Input } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { ValidationService } from './validation.service';

@Component({
  selector: 'control-messages',
  template: `<div class="text-danger" *ngIf="errorMessage !== null">{{errorMessage}}</div>`
})

export class ControlMessages {
  //errorMessage: string;
  @Input() control: FormControl;
  @Input() label: string = '';
 static onSubmit  :boolean=false;
  constructor() { }
getValidator(submit: boolean){
  ControlMessages.onSubmit = submit;
  console.log("Inside validator"+ControlMessages.onSubmit);
  //this.errorMessage();
}
  get errorMessage() {
    //console.log(this.control);
    //if (typeof this.control != 'undefined') {
      for (let propertyName in this.control.errors) {
        //debugger;
        if ((this.control.errors.hasOwnProperty(propertyName) && this.control.touched) || (this.control.errors.hasOwnProperty(propertyName) && ControlMessages.onSubmit)) {
          return ValidationService.getValidatorErrorMessage(this.label, propertyName, this.control.errors[propertyName]);
        }
      }
    //}
    return null;
  }
}