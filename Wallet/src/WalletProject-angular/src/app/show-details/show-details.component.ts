import { Component, OnInit } from '@angular/core';
import { AmountTransaction, HttpclientService,User} from '../service/httpclient.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-show-details',
  templateUrl: './show-details.component.html',
  styleUrls: ['./show-details.component.css']
})
export class ShowDetailsComponent implements OnInit {
  amountString:String;
  
  user:User=new User("","","",0,"","","","","");
  print:User=new User("","","",0,"","","","","");
  send:AmountTransaction=new AmountTransaction(this.user.username,this.user.password,this.user.accountNumber,"");
  constructor(private httpclientService:HttpclientService,private rou:Router) {
   this.user=this.httpclientService.userDetails;
 
   }
  
  ngOnInit(): void {
    this.send.username=this.httpclientService.use.username;
    this.send.password=this.httpclientService.use.password;
    this.httpclientService.getUserDetail(this.send).subscribe( data => {this.getData(data);
    //this.httpclientService.getDetails(send);
    
     // this.httpclientService.use=this.user;

    });
   
  }
  getDetails():void{
    this.send.username=this.httpclientService.use.username;
    this.send.password=this.httpclientService.use.password;
    this.httpclientService.getUserDetail(this.send).subscribe( data => {this.getData(data);
    //this.httpclientService.getDetails(send);
    
     // this.httpclientService.use=this.user;

    });
   // this.rou.navigate(['transfer/']);

};
  getStatus(data){
    this.user=data;
  }
  openLogin(){
    this.rou.navigate(['transfer/login']);
  }
  openWithdraw(){
    this.rou.navigate(['transfer/withdraw']);
  }
  openDeposit(){
    this.rou.navigate(['transfer/deposit']);
  }
  openFund(){
    this.rou.navigate(['transfer/fund']);
  }
  openBalance(){
    this.rou.navigate(['transfer/show']);
  }
  openTransaction(){
    this.rou.navigate(['transfer/print']);
  }
  openLogout(){
    this.rou.navigate(['transfer/show']);
    this.httpclientService.use=null;
  }
  openDetails(){
    this.rou.navigate(['transfer/details']);
    //this.user=this.httpclientService.userDetails;
  }
  openHome(){
    this.rou.navigate(['transfer/menu']);
  }
  openUpdate(){
    this.rou.navigate(['transfer/update']);
  }
  openDelete(){
    this.rou.navigate(['transfer/delete']);
  }
  getData(data){
this.print=data;
this.amountString=this.print.accountBalance.toString();
  }
  
}
