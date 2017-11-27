import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {AppRouterModule} from "./app.router";
import {UserModule} from "./user/user.module";
import {RoleModule} from "./role/role.module";
import {HomeComponent} from "./home/home/home.component";
import {TopNavbarComponent} from "./home/top-navbar/top-navbar.component";
import {LoginComponent} from "./home/login/login.component";
import {IndexComponent} from "./home/index/index.component";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TopNavbarComponent,
    LoginComponent,
    IndexComponent
  ],
  imports: [
    BrowserModule,
    AppRouterModule,
    UserModule,
    RoleModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
