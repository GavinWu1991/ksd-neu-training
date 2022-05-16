import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserApiService} from "../../core/api/user-api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  formDisabled: boolean = true;

  constructor(private readonly formBuilder: FormBuilder,
              private readonly userApiClient: UserApiService,
              private readonly router: Router) {

    this.registerForm = this.formBuilder.group(
      {
        username: ['', Validators.required],
        name: ['', Validators.required],
        gender: [1, Validators.required],
        birthday: ['', Validators.required],
        phoneNum: ['', Validators.required],
        homeAddress: ['', Validators.required],
        password: ['', [Validators.required, Validators.minLength(6)]],
        confirmPassword: ['', Validators.required],
        isAdmin: [false, Validators.required],
        acceptTerms: [false, Validators.requiredTrue]
      },
      {disable: this.formDisabled}
    );
  }

  // convenience getter for easy access to form fields
  get f() {
    return this.registerForm.controls;
  }

  registerForm: FormGroup;
  submitted = false;

  genderOpts = [{label: 'Male', value: 1}, {label: 'Female', value: 2}, {label: 'Other', value: 3}];

  ngOnInit() {
    // loading existing user data by given id
    const url = window.location.href;
    const userId = url.split('user/')[1];
    if (userId === 'new') {
      this.formDisabled = false;
      return;
    }

    this.userApiClient.getUserById(+userId).subscribe(user => {
      this.registerForm.patchValue(user);
      this.registerForm.disable();
    });

  }

  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.registerForm.invalid) {
      Object.keys(this.registerForm.controls).forEach(key => {
        this.registerForm.controls[key].markAsDirty();
      });
      this.registerForm.updateValueAndValidity();
      return;
    }

    this.userApiClient.create(this.registerForm.value).subscribe(() => {
      alert('User created success');
    });
  }

  onReset() {
    this.submitted = false;
    this.registerForm.reset();
  }

}
