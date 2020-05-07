import { Component, OnInit } from '@angular/core';
import { UserDetails, HttpclientService,User } from '../service/httpclient.service';


@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {
 public userId:String;
 
 public email:String;
public mobile:String;
public accountType:String;
 public username:String;
 public password:String;
 public print:String;
 
acc:UserDetails=new UserDetails("","","","","","");
user:User=new User("","","",0,"","","","","");
 //acc:Account =new Account(this.custId,this.custName,this.custEmail,this.custMobile,this.custUsername,this.custPassword,0);
 
  constructor(private httpclientService:HttpclientService) { }
  
  
  
  ngOnInit(): void {
  }
  addAccount():void{
    this.httpclientService.addAccount(this.acc).subscribe( data => {this.printAccountNumber(data);
      if(data){
      alert("Account created successfully"+"  Your account number is: "+this.user.accountNumber);
      }
      else{
        alert("Username or UserId already exists");
      }
    });

};
printAccountNumber(data){
  this.user=data;
}
}
