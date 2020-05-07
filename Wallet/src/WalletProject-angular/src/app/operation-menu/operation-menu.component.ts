import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { HttpclientService ,User} from '../service/httpclient.service';

@Component({
  selector: 'app-operation-menu',
  templateUrl: './operation-menu.component.html',
  styleUrls: ['./operation-menu.component.css']
})
export class OperationMenuComponent implements OnInit {
  user:User=new User("","","",0,"","","","","");
  constructor(private rou:Router,private httpclientService:HttpclientService) { }

  ngOnInit(): void {
    this.user=this.httpclientService.use;
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
  
