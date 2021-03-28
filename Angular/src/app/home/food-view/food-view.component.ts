import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-food-view',
  templateUrl: './food-view.component.html',
  styleUrls: ['./food-view.component.css']
})
export class FoodViewComponent implements OnInit {

  favourites:any;
  panelOpenState=false;
  constructor(private httpClient:HttpClient) { }

  ngOnInit(): void {
    const headers={
      "Access-Control-Allow-Origin":"*"
    }
    this.httpClient.get<any>("http://localhost:9001/api/v1/list",
    {headers:new HttpHeaders().set('Access-Control-Allow-Origin','*')})
    .subscribe(data=>{
      console.log(data);
      this.favourites=data;
    },
    error=>{
      console.log(error);
    })
  }


}
