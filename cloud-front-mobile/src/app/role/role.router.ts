import {RouterModule} from '@angular/router'
import {RoleComponent} from "./role.component";
import {ListComponent} from "./list/list.component";
import {HomeComponent} from "../common/home/home.component";

export const RoleRouter = RouterModule.forChild([
  {
    path: '',
    component: HomeComponent,
    children: [
      {
        path: 'role',
        component: RoleComponent,
        children: [
          {path: 'list', component: ListComponent}
        ]
      }
    ]
  }
])
