import {RouterModule} from '@angular/router'
import {HomeComponent} from "./home/home/home.component";
import {LoginComponent} from "./home/login/login.component";
import {IndexComponent} from "./home/index/index.component";
import {NgModule} from "@angular/core";

const routes = [
  {
    path: '',
    redirectTo: 'index',
    pathMatch: 'full'
  },
  {
    path: '',
    component: HomeComponent,
    data: {title: 'Home'},
    children: [
      {path: 'index', component: IndexComponent}
    ]
  },
  {
    path: 'login',
    component: LoginComponent
  }
];

@NgModule({
  //H5模式。改成true后可以将URL换成井号(#)
  imports: [RouterModule.forRoot(routes, {useHash: false})],
  exports: [RouterModule]
})
export class AppRouterModule {
}
