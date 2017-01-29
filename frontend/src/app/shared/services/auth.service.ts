import { Channel } from '../models/channel.model';
import { FeedsService } from './feeds.service';
import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { User } from '../models/user.model';
import { CookieService } from 'angular2-cookie/core';

import { Subscriber } from 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class AuthService {
    public user: User;
    private loginUrl: string = 'http://localhost:8080/login';
    private signupUrl: string = 'http://localhost:8080/register';
    private headers: Headers;

    constructor(private http: Http, private cookies: CookieService) {
        this.user = new User();
        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json');
    }

    login(name: string, password: string): Observable<User> {
        let data: Observable<User> = this.http.post(this.loginUrl, {name: name, password: password}, {headers: this.headers})
            .map(this.extractData)
            .catch(this.handleError);

        return data;
    }

    signup(name: string, password: string): Observable<User> {
        let data: Observable<User> = this.http.post(this.signupUrl, {name: name, password: password}, {headers: this.headers})
            .map(this.extractData)
            .catch(this.handleError);

        return data;
    }

    edit(userEdit: User) {

    }

    logout() {
        this.user.id = '';
        this.user.name = '';
        this.user.token = '';
        this.user.rss = new Array<Channel>();
        this.cookies.remove('access_token');
    }

    private extractData(res: Response): User {
        let body = <User>res.json();
        return body;
    }

    private handleError(error: Response | any) {
        // In a real world app, we might use a remote logging infrastructure
        let errMsg: string;
        if (error instanceof Response) {
            const body = error.json() || '';
            const err = body.error || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Observable.throw(errMsg);
    }

    authenticated(): boolean {
        if (this.user.id.length > 0) {
            return true;
        }
        return false;
    }
}