import { Component, OnInit } from '@angular/core';
import { AmountTransaction, HttpclientService,User } from '../service/httpclient.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-show-balance',
  templateUrl: './show-balance.component.html',
  styleUrls: ['./show-balance.component.css']
})
export class ShowBalanceComponent implements OnInit {
bal:AmountTransaction=new AmountTransaction("","","","");
user:User=new User("","","",0,"","","","","");
balance:String="";

  constructor(private httpClientService:HttpclientService,private rou:Router) { }
onBalance(value:any){}
  ngOnInit(): void {
  }
  getData(){
  this.httpClientService.getBalance(this.bal).subscribe( data => {this.setData(data);
    
  });

};
  
setData(data){
  this.user=data;
  this.balance=this.user.accountBalance.toString();
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

}
