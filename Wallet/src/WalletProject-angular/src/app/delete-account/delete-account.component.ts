import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { HttpclientService } from '../service/httpclient.service';
import { AmountTransaction,User} from '../service/httpclient.service';

@Component({
  selector: 'app-delete-account',
  templateUrl: './delete-account.component.html',
  styleUrls: ['./delete-account.component.css']
})
export class DeleteAccountComponent implements OnInit {
  user:User=new User("","","",0,"","","","","");
  print:User=new User("","","",0,"","","","","");
  deleteData:AmountTransaction=new AmountTransaction("","","","");
  constructor(private rou:Router,private httpclientService:HttpclientService) { }

  ngOnInit(): void {
  }
  deleteDetails():void{
    this.deleteData.username=this.httpclientService.use.username;
    this.deleteData.password=this.httpclientService.use.password;
    this.httpclientService.deleteAccount(this.deleteData).subscribe( data => {

   alert("User Account Deleted");
   this.rou.navigate(['transfer/show']);

    });
   

};
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
    this.httpclientService.userDetails=this.httpclientService.use;
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
