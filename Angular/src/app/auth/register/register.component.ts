import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})


export class RegisterComponent implements OnInit {

  constructor() { }

  user=new FormGroup({
    email:new FormControl(),
    username:new FormControl(),
    password:new FormControl(),
    profileImage:new FormControl()
  })
  src:any;
  fileToUpload: any;
  ngOnInit(): void {
  }

  public loadFile(files:any) {
    console.log(files.target.files);
    
    let formData = new FormData();
    formData.append("profileImage",files.target.files);
    console.log(formData.getAll)
  }

  onSubmit(){
    console.log(this.user.value);
  }

}
