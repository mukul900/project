import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import {HttpClient,HttpHeaders} from '@angular/common/http'
import { NgxSpinnerModule, NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-food-index',
  templateUrl: './food-index.component.html',
  styleUrls: ['./food-index.component.css']
})
export class FoodIndexComponent implements OnInit {

  panelOpenState = false;
  Results:string="";
  food=new FormControl();
  constructor(private httpClient:HttpClient,private spinner:NgxSpinnerService) { }
  highfields:any;
  favourites={
    food:"",
    score:""
  }
  ngOnInit(): void {
  }

  searchFood()
  {
    this.spinner.show();
    this.Results="Search Results";
    console.log(this.food.value);
    const headers={
      "api_key":"Lcis769TnWTUYdMtkVoOeiYYUbwuZoeahPmQ7I2F",
      "query":this.food.value
    }
    this.httpClient.get<any>("https://api.nal.usda.gov/fdc/v1/foods/search",{params:headers})
    .subscribe(data=>{
      console.log(data.foods);
      this.highfields=data.foods;
      this.spinner.hide();
    },
    error=>{
      console.log(error);
    })
    //this.spinner.hide();
  }

  addFavourites(data:any){
    console.log(data);
      this.favourites.food=data.description;
      this.favourites.score=data.score;
      console.log(this.favourites);
      
  }
}
