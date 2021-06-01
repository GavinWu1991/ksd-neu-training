import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Message} from "primeng/api";
import {UserApiService} from "../core/api/user-api.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent {

  loginForm: FormGroup;
  msgs: Message[] = [];

  constructor(private readonly formBuilder: FormBuilder,
              private readonly httpClient: HttpClient) {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  onLogin() {
    if (this.loginForm.invalid) {
      this.msgs = [{severity: 'error', detail: 'Login form invalid.'}];
    }

    this.httpClient.post<any>(`/login?username=${this.loginForm.value.username}&password=${this.loginForm.value.password}`, {})
      .subscribe(result => {
        this.msgs = [{severity: 'success', detail: 'Login Success.'}];
      }, ({error}) => {
        this.msgs = [{severity: 'error', detail: error.message}];
      });
  }
}
