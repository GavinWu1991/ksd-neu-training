import {Injectable} from '@angular/core';
import {UserApiService} from "../../core/api/user-api.service";
import {Observable, of} from "rxjs";
import {User} from "../../shared/model/user";

@Injectable({
  providedIn: 'root'
})
export class ViewUserService {

  constructor(private readonly userApiClient: UserApiService) {
  }

  getUserData(): Observable<User | null> {
    // loading existing user data by given id
    const url = window.location.href;
    const numberParams = url.match(/(?:user\/)(\d+)/);

    if (numberParams) {
      const id = numberParams[1];
      return this.userApiClient.getUserById(+id);
    }

    return of(null);

  }
}
