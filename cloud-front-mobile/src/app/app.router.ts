import {RouterModule} from '@angular/router'
import {HomeComponent} from "./common/home/home.component";
import {LoginComponent} from "./common/login/login.component";
import {LoginGuard} from "./common/login/login.guard";

export const AppRouter = RouterModule.forRoot([
  {
    path: '',
    component: HomeComponent,
    canActivate: [LoginGuard],
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  }
])
