import { Component, OnInit } from '@angular/core';
import { AmountTransaction, HttpclientService,User } from '../service/httpclient.service';
import {Router} from'@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginDetails:AmountTransaction=new AmountTransaction("","","","");
  user:User=new User("","","",0,"","","","","");
  constructor(private httpclientService:HttpclientService,private rou:Router) { }

  ngOnInit(): void {
  }
  loginValidate():void{
    this.httpclientService.loginData(this.loginDetails).subscribe( data => {this.getLogin(data);

      if(data){
        this.rou.navigate(['transfer/menu']);
        this.httpclientService.use=this.user;
      }
      else{
        alert("Invalid login details");
      }
    });

};
getLogin(data){
this.user=data;
}

}
