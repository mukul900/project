import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {map} from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(private httpClient:HttpClient) {

  }

  authenticateUser(data:any) {
   return this.httpClient.post("http://localhost:3000/auth/v1/",data);
  }

  setBearerToken(token:any) {
    localStorage.setItem("bearerToken",token);
  }

  getBearerToken() {
    return localStorage.getItem("bearerToken");
  }

  isUserAuthenticated(token:any): Promise<any> {
      return this.httpClient.post("http://localhost:3000/auth/v1/isAuthenticated",{},{
        headers:new HttpHeaders().set("Authorization",`Bearer ${token}`)
      }).toPromise();
      //.pipe(map(response=>response['isAuthenticated']))
      // return this.httpClient.post("http://localhost:3000/auth/v1/isAuthenticated",{},{
      //   headers:new HttpHeaders().set("Authorization",`Bearer ${token}`)
      // });
  }

}
