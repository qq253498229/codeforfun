import {RouterModule} from "@angular/router";
import {UserComponent} from "./user.component";
import {ListComponent} from "./list/list.component";
import {HomeComponent} from "../home/home/home.component";
import {EditComponent} from "./edit/edit.component";
import {LoginGuard} from "../guard/login/login.guard";
import {ConfirmGuard} from "./guard/confirm.guard";

export const UserRouter = RouterModule.forChild([
  {
    path: '',
    component: HomeComponent,
    children: [
      {
        path: 'user',
        redirectTo: 'user/list',
        pathMatch: 'full'
      },
      {
        path: 'user',
        component: UserComponent,
        children: [
          {path: 'list', component: ListComponent},
          {
            path: 'edit',
            component: EditComponent,
            canActivate: [LoginGuard],
            canDeactivate: [ConfirmGuard]
          }
        ]
      }
    ]
  }
])
