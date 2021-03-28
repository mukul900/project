import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  errMessage:string="";
  usernameError:string="";
  passwordError:string="";
  user=new FormGroup({
  username:new FormControl(''),
  password:new FormControl('')
  });
  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    
    if(this.user.value.username=="" && this.user.value.password=="")
      this.errMessage="Fields can't be empty";
    else if(this.user.value.username=="" && this.user.value.password!="")
      this.usernameError="Username can't be empty";
    else if(this.user.value.username!="" && this.user.value.password=="")
      this.passwordError="Password can't be empty"
    else
    {
      this.errMessage="";
      this.usernameError="";
      this.passwordError="";
      console.log(this.user.value);
      this.router.navigate(['/home/index'])
    }
      
  }

}
