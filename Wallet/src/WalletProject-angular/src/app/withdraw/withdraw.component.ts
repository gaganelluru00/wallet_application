import { Component, OnInit } from '@angular/core';
import { AmountTransaction, HttpclientService ,User} from '../service/httpclient.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent implements OnInit {
  public username:String;
  public password:String;
  public accNumber:String;
  public amount:String;
with:AmountTransaction=new AmountTransaction("","","","");
user:User=new User("","","",0,"","","","","");
  constructor(private httpclientService:HttpclientService,private rou:Router) { }
onWithdraw(value:any){}
  ngOnInit(): void {
  }
  withdrawAmount():void{
    this.with.username=this.httpclientService.use.username;
    this.with.password=this.httpclientService.use.password;
    this.httpclientService.withdrawAmount(this.with).subscribe( data => {this.getData(data);
      
      if(data){
        if(this.user.username=="Incorrect Username or Password"){
          alert("Incorrect Username or Password");
        }
        else{
        alert("Balance in the account is "+this.user.accountBalance);}
      }
      if(data==null){
        alert("Insufficient Balance");
      }
    });

};
getData(data){
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
