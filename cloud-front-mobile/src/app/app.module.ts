import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HashLocationStrategy, LocationStrategy} from '@angular/common'

import {AppComponent} from './app.component';
import {AppRouter} from "./app.router";
import {UserModule} from "./user/user.module";
import {RoleModule} from "./role/role.module";
import {HomeComponent} from "./common/home/home.component";
import {TopNavbarComponent} from "./common/top-navbar/top-navbar.component";
import {LoginComponent} from "./common/login/login.component";
import {LoginGuard} from "./common/login/login.guard";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TopNavbarComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRouter,
    UserModule,
    RoleModule
  ],
  providers: [
    LoginGuard,
    //地址栏换成井号(#)
    {provide: LocationStrategy, useClass: HashLocationStrategy}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
