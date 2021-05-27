import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  registerForm: FormGroup;

  genderOpts = [{label: 'Male', value: 1},
    {label: 'Female', value: 2},
    {label: 'Other', value: 3}];

  constructor(
    private readonly fb: FormBuilder,
    private readonly http: HttpClient
  ) {
    this.registerForm = this.fb.group({
      username: ['', Validators.required]
    })
  }

  get f() {
    return this.registerForm.controls;
  }

  ngOnInit(): void {

  }


  onSubmit() {
    this.http.post('/user', this.registerForm.value)
      .subscribe(result => alert(result));
  }
}
