import { Component, OnInit } from '@angular/core';
import { AmountTransaction, HttpclientService,User } from '../service/httpclient.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-fund-transfer',
  templateUrl: './fund-transfer.component.html',
  styleUrls: ['./fund-transfer.component.css']
})
export class FundTransferComponent implements OnInit {
  public username:String;
  public password:String;
  public accNumber:String;
  public amount:String;
  fundT:AmountTransaction=new AmountTransaction("","","","");
  user:User=new User("","","",0,"","","","","");
  reply:String;
  constructor(private httpclientService:HttpclientService,private rou:Router) { }

  ngOnInit(): void {
  }
  fundTransferAmt():void{
    this.fundT.username=this.httpclientService.use.username;
    this.fundT.password=this.httpclientService.use.password;
    this.httpclientService.fundTransfer(this.fundT).subscribe( data => {this.getTransfer(data);
      if(data){
       
        if(this.user.accountNumber=="Incorrect account number"){
          alert("Incorrect account number");
        }
        else{
          alert("Amount Transfered .Balance Amount-"+this.user.accountBalance);
        }
      }
      else{
        alert("Insufficient Balance");
      }
    });

};
getTransfer(data){
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
  this.httpclientService.userDetails=this.user;
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


}
