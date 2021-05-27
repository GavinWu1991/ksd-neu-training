import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'first-ng-app';
  menuItems = [
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
      routerLink: 'admin/user/-1'
    },
    {
      label: 'Login',
      routerLink: 'auth/login'
    }
  ];
}
