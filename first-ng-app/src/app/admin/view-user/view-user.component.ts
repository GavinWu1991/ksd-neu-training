import {Component, OnInit} from '@angular/core';
import {ViewUserService} from "./view-user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css']
})
export class ViewUserComponent implements OnInit {

  constructor(private readonly _viewUserService: ViewUserService,
              private readonly _router: Router) {
  }

  ngOnInit(): void {
    this._viewUserService.getUserData().subscribe(user => {
      // display to user
      console.log(user);
    });
  }

  backToHome() {
    this._router.navigate(['/admin/users']);
  }

}
