import { Component,Input,ViewChild } from '@angular/core';
import {HttpModule, Http,Headers,RequestOptions} from "@angular/http";
import { Router,ActivatedRoute} from '@angular/router';
import { FileUploader } from 'ng2-file-upload';
import {Observable} from 'rxjs/Rx';
import{EirCreateComponent} from './eir.createEnquiry';
import{DataService} from '../services/eir.getData';

@Component({
  selector: 'kycComponent',
  templateUrl: '../html/kyc.html',
  providers: [DataService]
})
export class KycComponent 
{

  @ViewChild('myInput')
  myInputVariable: any;
   public issOnlyBIR:boolean;
    public isCir:boolean;
    public isCombo:boolean;
   public fileList1: FileList;
   size : number;
   file : any[]=[];
   fileListToPass: any =FileList;
   selectedfile:File;
   rowData = [
     {
       fileNm:'',
       fileType:'',
       fileSize: this.size,
       file:this.selectedfile
     }
   ]
   
  constructor(private _routeParams: ActivatedRoute,private router: Router,private _http: Http,private _dataService:DataService){
     _routeParams.queryParams.subscribe(params => {this.issOnlyBIR = params['isOnlyBir'] || 'false',
     this.isCombo = params['isCombo'] || 'false',this.isCir = params['isCir'] || 'false'});
    this.rowData.pop();
    this.fileListToPass;
  }

  kycSubmit(){
    debugger;
    let fileList: FileList = this.fileList1;
    let formData:FormData = new FormData();

    for(var i=0;i<this.rowData.length;i++){
        let file: File = this.rowData[i].file;
        formData.append(file.name, file, file.name);  
    }
    
    this._dataService.uploadKyc(formData,EirCreateComponent.reqId).subscribe(data => console.log('success'),error => console.log(error));
    this.router.navigate(['inputForEnquiry'],{ queryParams: { isOnlyBir: this.issOnlyBIR, isCir: this.isCir, isCombo: this.isCombo} });
  }

  back()
  {
    this.router.navigate(['createEnquiry']);
  }

uploadFile(event){
  // debugger;
  this.fileList1 = event.target.files;
  
  this.file = event.target.files;    
}

  upload()
  {
    
    //let fileList: FileList = this.fileList1;
    for(var i=0;i<this.fileList1.length;i++) 
    {
      this.file[i] = this.fileList1[i];     
        this.rowData.push({
          fileNm: this.file[i].name,
          fileType: this.file[i].type,
          fileSize: this.file[i].size,
           file: this.file[i]
        })   
    }
    this.myInputVariable.nativeElement.value = "";
  }

  deleteFile(index){    
    this.rowData.splice(index,1);   
  }

  resetFile(){
    this.rowData.splice(0,this.rowData.length);
    this.myInputVariable.nativeElement.value = "";
  }
}