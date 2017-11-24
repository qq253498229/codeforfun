import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ListComponent} from './list/list.component';
import {EditComponent} from './edit/edit.component';
import {UserComponent} from './user.component';
import {UserRouter} from "./user.router";

@NgModule({
  imports: [
    CommonModule,
    UserRouter
  ],
  declarations: [ListComponent, EditComponent, UserComponent]
})
export class UserModule {
}
