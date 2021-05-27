import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";

const adminModule = () =>
  import('./admin/admin.module').then(module => module.AdminModule);

const routes: Routes = [
  {
    path: 'admin',
    loadChildren: adminModule
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
