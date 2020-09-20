import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginSuccessComponent } from './login-success/login-success.component';
import { LoginComponent } from './login/login.component';
import { RegisterSuccessComponent } from './register-success/register-success.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'loginsuccess',component:LoginSuccessComponent},
  {path:'register',component:RegistrationComponent},
  {path:'registersuccess',component:RegisterSuccessComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
