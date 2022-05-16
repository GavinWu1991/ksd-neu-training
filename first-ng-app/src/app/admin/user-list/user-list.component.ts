import {Component, OnInit} from '@angular/core';
import {Message} from "primeng/api";
import {UserApiService} from "../../core/api/user-api.service";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  msgs: Message[] = [{summary: "users", severity: "info"}]

  constructor(private readonly _userApiService: UserApiService) {
  }

  ngOnInit(): void {
    this._userApiService.count().subscribe(({count}) => {
      this.msgs = [{summary: `${count} users`, severity: "info"}];
    })
  }
}
