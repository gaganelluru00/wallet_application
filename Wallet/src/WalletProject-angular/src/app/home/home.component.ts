import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private rou:Router) { }

  ngOnInit(): void {
  }
  openCreate(){
    this.rou.navigate(['transfer/add']);
  }
  openLogin(){
    this.rou.navigate(['transfer/login']);
  }

}
