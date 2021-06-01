import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {AuthComponent} from "./auth/auth.component";

const adminModule = () =>
  import('./admin/admin.module').then(module => module.AdminModule);

const routes: Routes = [
  {
    path: 'admin',
    loadChildren: adminModule
  }, {
    path: 'auth',
    component: AuthComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
