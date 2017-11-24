import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ListComponent} from './list/list.component';
import {RoleComponent} from './role.component';
import {RoleRouter} from "./role.router";

@NgModule({
  imports: [
    CommonModule,
    RoleRouter
  ],
  declarations: [ListComponent, RoleComponent]
})
export class RoleModule {
}
