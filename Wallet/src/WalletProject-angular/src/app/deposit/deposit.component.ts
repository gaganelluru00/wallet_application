import { Component, OnInit } from '@angular/core';
import { AmountTransaction, HttpclientService,User} from '../service/httpclient.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {
public username:String;
public password:String;
public accNumber:String;
public amount:String;
public c:number;
dep:AmountTransaction=new AmountTransaction("","","","");
detail:AmountTransaction=new AmountTransaction("","","","");
user:User=new User("","","",0,"","","","","");


  constructor(private httpclientService:HttpclientService,private rou:Router) { }

onDeposit(value:any){}

  ngOnInit(): void {
  }
  
  depositAmount():void{
    this.c++;
    this.dep.username=this.httpclientService.use.username;
    this.dep.password=this.httpclientService.use.password;
    this.httpclientService.depositAmount(this.dep).subscribe( data => {this.getStatus(data);
     if(this.user.username=="Incorrect Username or Password")
      {alert("Incorrect Username or Password");}
      else{
      alert("Amount deposited in the account. Balance Amount-"+this.user.accountBalance);}
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
openHome(){
  this.rou.navigate(['transfer/menu']);
}
openUpdate(){
  this.rou.navigate(['transfer/update']);
}
openDelete(){
  this.rou.navigate(['transfer/delete']);
}

openDetails(){
  
  /*this.detail.username=this.httpclientService.use.username;
  this.detail.password=this.httpclientService.use.password;
  this.detail.accNumber=this.httpclientService.use.accountNumber;
  
  this.httpclientService.getUserDetail(this.detail).subscribe( data=>{
    this.getDetails(data);*/
    this.rou.navigate(['transfer/details']);
  //})
  
  //if(this.c>0)
  //this.httpclientService.userDetails=this.user;
  //else
//this.httpclientService.userDetails=this.httpclientService.use;
}
getDetails(data){
  this.httpclientService.userDetails=data;
}

}
