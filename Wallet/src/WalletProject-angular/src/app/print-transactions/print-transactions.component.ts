import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { AmountTransaction, HttpclientService,User, Transaction } from '../service/httpclient.service';


@Component({
  selector: 'app-print-transactions',
  templateUrl: './print-transactions.component.html',
  styleUrls: ['./print-transactions.component.css']
})
export class PrintTransactionsComponent implements OnInit {
  public username:String;
  public password:String;
  public accNumber:String;
  public amount:String;
  transData:AmountTransaction=new AmountTransaction("","","","");
  user:User=new User("","","",0,"","","","","");
  transactions:Transaction[];

  constructor(private rou:Router,private httpclientService:HttpclientService) { }

  ngOnInit(): void {
    this.transData.accNumber=this.httpclientService.use.accountNumber;
    this.transData.password=this.httpclientService.use.password;
    this.httpclientService.printData(this.transData).subscribe( data => {
      if(data){
        this.getTransfer(data);
      }
      else{
        alert("No transactions performed");
      }
    });
  }
  printTransactions():void{
   /* this.transData.accNumber=this.httpclientService.use.accountNumber;
    this.transData.password=this.httpclientService.use.password;
    this.httpclientService.printData(this.transData).subscribe( data => {
      if(data){
        this.getTransfer(data);
      }
      else{
        alert("No transactions performed");
      }
    });*/

};
getTransfer(data){
this.transactions=data;
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
    //this.httpclientService.userDetails=this.user;
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
