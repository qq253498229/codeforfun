import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {UserComponent} from "../user.component";

@Injectable()
export class ConfirmGuard implements CanDeactivate<UserComponent> {
  canDeactivate(component: UserComponent, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {
    //todo
    // return confirm('确定关闭？');
    return true;
  }

}
