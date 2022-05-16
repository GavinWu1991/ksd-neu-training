import {Component, OnInit} from '@angular/core';
import {Message} from "primeng/api";
import {UserApiService} from "../../core/api/user-api.service";
import {User} from "../../shared/model/user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  msgs: Message[] = [{summary: "users", severity: "info"}]
  users: User[] = [];

  constructor(private readonly _userApiService: UserApiService,
              private readonly _router: Router) {
  }

  ngOnInit(): void {
    // this._userApiService.count().subscribe((response) => {
    //   const count = response.count;
    //   this.msgs = [{summary: `${count} users`, severity: "info"}];
    // })
    this._userApiService.count().subscribe(({count}) => {
      this.msgs = [{summary: `${count} users`, severity: "info"}];
    })

    this._userApiService.getAll().subscribe((users) => {
      this.users = users;
    })
  }

  viewUser(id: number) {
    this._router.navigate(['/admin/user', id])
  }
}
