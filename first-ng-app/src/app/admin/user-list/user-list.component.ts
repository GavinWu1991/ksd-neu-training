import {Component, OnInit} from '@angular/core';
import {ConfirmationService, Message} from "primeng/api";
import {UserApiService} from "../../core/api/user-api.service";
import {User} from "../../shared/model/user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
  providers: [ConfirmationService]
})
export class UserListComponent implements OnInit {

  msgs: Message[] = [{summary: "users", severity: "info"}]
  users: User[] = [];

  constructor(private readonly _userApiService: UserApiService,
              private readonly _router: Router,
              private readonly _confirmationService: ConfirmationService) {
  }

  ngOnInit(): void {
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

  deleteUser(id: number, event: any) {
    this._confirmationService.confirm({
      target: event.target,
      message: 'Are you sure that you want to delete user?',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        //confirm action
        this._userApiService.delete(id).subscribe({
          next: () => {
            // reload user list
            this.ngOnInit();
          },
          error: (message) => {
            alert(JSON.stringify(message));
          }
        })
      },
      reject: () => {
        //reject action
        console.log("master branch")
      }
    });
  }
}
