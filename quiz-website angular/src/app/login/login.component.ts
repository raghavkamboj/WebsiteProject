import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule , FormGroup} from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserConnectionService } from '../user-connection.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User();

  constructor(private _service: UserConnectionService, private _router: Router) { }

  ngOnInit(): void {
  }

  loginUser(){
    this._service.loginUserHTTP(this.user).subscribe(
      data => {
        console.log("Login request received", )
        this._router.navigate(['/loginsuccess'])
      }, 
      error => console.log("exception occured")
    )
  }

}
