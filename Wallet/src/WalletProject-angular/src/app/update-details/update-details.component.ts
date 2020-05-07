import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { HttpclientService, UserDetails } from '../service/httpclient.service';
import { AmountTransaction, User} from '../service/httpclient.service';

@Component({
  selector: 'app-update-details',
  templateUrl: './update-details.component.html',
  styleUrls: ['./update-details.component.css']
})
export class UpdateDetailsComponent implements OnInit {
  user:User=new User("","","",0,"","","","","");
  update:UserDetails=new UserDetails("","","","","","");
  constructor(private rou:Router,private httpclientService:HttpclientService) { }

  ngOnInit(): void {
  }
  updateDetail():void{
    this.update.username=this.httpclientService.use.username;
    this.update.password=this.httpclientService.use.password;
    this.httpclientService.updateAccount(this.update).subscribe( data => {this.getData(data);
      
     alert("Data Updated");
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
  getData(data){
    this.user=data;
  }
  
}
