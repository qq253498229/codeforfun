import {RouterModule} from "@angular/router";
import {UserComponent} from "./user.component";
import {ListComponent} from "./list/list.component";
import {HomeComponent} from "../common/home/home.component";

export const UserRouter = RouterModule.forChild([
  {
    path: '',
    component: HomeComponent,
    children: [
      {
        path: 'user',
        component: UserComponent,
        children: [
          {path: 'list', component: ListComponent}
        ]
      }
    ]
  }
])
