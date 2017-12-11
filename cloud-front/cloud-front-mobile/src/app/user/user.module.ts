import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ListComponent} from './list/list.component';
import {EditComponent} from './edit/edit.component';
import {UserComponent} from './user.component';
import {UserRouter} from "./user.router";
import {LoginGuard} from "../guard/login/login.guard";
import {ConfirmGuard} from "./guard/confirm.guard";

@NgModule({
  imports: [
    CommonModule,
    UserRouter
  ],
  declarations: [ListComponent, EditComponent, UserComponent],
  providers: [LoginGuard, ConfirmGuard]
})
export class UserModule {
}
