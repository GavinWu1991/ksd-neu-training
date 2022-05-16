import {Component} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'first-ng-app';
  menuItems: MenuItem[] = [
    {
      label: 'Home',
      routerLink: 'admin',
    },
    {
      label: 'Users',
      routerLink: 'admin/users'
    },
    {
      label: 'Add User',
      routerLink: 'admin/user/new'
    },
    {
      label: 'Login',
      routerLink: 'auth'
    }
  ];
}
