import { Component,Input,ViewChild } from '@angular/core';
import {HttpModule, Http,Headers,RequestOptions} from "@angular/http";
import { Router,ActivatedRoute} from '@angular/router';
import { FileUploader } from 'ng2-file-upload';
import {Observable} from 'rxjs/Rx';
import{EirCreateComponent} from './eir.createEnquiry';
import{DataService} from '../services/eir.getData';
import { LoaderService } from '../services/eir.loader';

@Component({
  selector: 'kycComponent',
  templateUrl: '../html/kyc.html',
  providers: [DataService],
  styleUrls: ['../app.component.css']
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
   data =<any>{};
    showLoader:boolean;
   rowData = [
     {
       fileNm:'',
       fileType:'',
       fileSize: this.size,
       file:this.selectedfile
     }
   ]
   
  constructor(private _routeParams: ActivatedRoute,private router: Router,private _http: Http,private _dataService:DataService,private loaderService: LoaderService){
    this.showLoader=true;
     _routeParams.queryParams.subscribe(params => {this.issOnlyBIR = params['isOnlyBir'] || 'false',
     this.isCombo = params['isCombo'] || 'false',this.isCir = params['isCir'] || 'false'});
    this.rowData.pop();
    this.fileListToPass;
    this.loaderService.status.subscribe((val: boolean) => {
            this.showLoader = val;

        });
  }

  kycSubmit(){
    debugger;
    this.loaderService.display(true); 
    let fileList: FileList = this.fileList1;
    let formData:FormData = new FormData();
    console.log("Description::::"+this.data.description);
    formData.append("Description",this.data.description);
    if(this.rowData.length > 0){
        for(var i=0;i<this.rowData.length;i++){
            let file: File = this.rowData[i].file;
            formData.append(file.name, file, file.name);  
        }
        this.data.fileData = formData;        
        this._dataService.uploadKyc(formData,EirCreateComponent.reqId).subscribe(
          (data) => {
          this.navigate();
          this.loaderService.display(false);           
           } );
        
    }
    else{
        alert("Please upload the kyc document !!!");
        this.loaderService.display(false);
        this.router.navigate(['kycComponent']);
    }
  }

  navigate(){
        console.log("inside navigate method...........");
        this.router.navigate(['inputForEnquiry'],{ queryParams: { isOnlyBir: this.issOnlyBIR, isCir: this.isCir, isCombo: this.isCombo} });
     }
  back()
  {
    console.log("Back method::"+EirCreateComponent.reqId);
    this.router.navigate(['createEnquiry'],{queryParams: {reqId: EirCreateComponent.reqId}});
  }

uploadFile(event){
  // debugger;
  this.fileList1 = event.target.files;
  
  this.file = event.target.files;    
}

  upload()
  {
    
      if(this.fileList1 != undefined && this.fileList1.length > 0){
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
    else{
      alert("No file selected");
      this.loaderService.display(false);
    }
  }

  deleteFile(index){    
    this.rowData.splice(index,1);   
  }

  resetFile(){
    this.data.description="";
    this.rowData.splice(0,this.rowData.length);
    this.myInputVariable.nativeElement.value = "";
  }
}