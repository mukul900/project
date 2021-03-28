import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  loginStatus:string="logout";
  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  routeToFavourites(){
    this.router.navigate(['/home/view']);
  }
  onClick(){
    if(this.loginStatus=="logout")
    {
    this.loginStatus="login"
    }else
    {
      this.loginStatus="logout"
    }
   this.router.navigate(['/auth/login']);
  }
}
