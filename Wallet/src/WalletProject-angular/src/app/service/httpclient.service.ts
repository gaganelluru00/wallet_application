import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

export class UserDetails{
  constructor(
  public userId:String,
  public email:String,
  public mobile:String,
  public accountType:String,
 public username:String,
 public password:String
   ){
}
}
export class AmountTransaction{
  constructor(
    public username:String,
    public password:String,
    public accNumber:String,
    public amount:String
  ){}
}
export class User{
  constructor(
    public userId:String,
  public email:String,
  public mobile:String,
  public accountBalance:number,
 public time:String,
	public accountType:String,
	public accountNumber:String,
public username:String,
	public password:String
  ){}
}
export class Transaction{
  constructor(
    public userId:number,
	public  transId:String,
	public transTime:String,
	public tType:String,
	public recId:String,
	public sendId:String,
	public transAmount:number,
	public updatedBalance:number
  ){}
}
@Injectable({
  providedIn: 'root'
})
export class HttpclientService {

  constructor(private httpClient:HttpClient) { }
  use:User=new User("","","",0,"","","","","");
  userDetails:User=new User("","","",0,"","","","","");
  u:User=new User("","","",0,"","","","","");

  public getDetails(send):void{
    
    this.loginData(send).subscribe( data => {this.getData(data);
    
     // this.httpclientService.use=this.user;

    });
   // this.rou.navigate(['transfer/']);

};
getData(data){
  this.u=data;}
  public addAccount(account){
return this.httpClient.post<UserDetails>("http://localhost:8077/transfer/add",account);
  }


  public depositAmount(account){
    return this.httpClient.put<AmountTransaction>("http://localhost:8077/transfer/deposit",account);
  }
  public withdrawAmount(account){
    return this.httpClient.put<AmountTransaction>("http://localhost:8077/transfer/withdraw",account);
  }
  public fundTransfer(account){
    return this.httpClient.post<AmountTransaction>("http://localhost:8077/transfer/fund",account);
  }
 
  public getBalance(account){
    return this.httpClient.post<User>("http://localhost:8077/transfer/show",account);
  }
  public loginData(account){
    return this.httpClient.post<AmountTransaction>("http://localhost:8077/transfer/login",account);
  }
  public printData(account){
    return this.httpClient.post<AmountTransaction>("http://localhost:8077/transfer/print",account);
  }
  public getUserDetail(account){
    return this.httpClient.put<AmountTransaction>("http://localhost:8077/transfer/details",account);
  }
  public deleteAccount(account){
    return this.httpClient.put<AmountTransaction>("http://localhost:8077/transfer/delete",account);
  }
  public updateAccount(account){
    return this.httpClient.post<UserDetails>("http://localhost:8077/transfer/update",account);
  }

}
