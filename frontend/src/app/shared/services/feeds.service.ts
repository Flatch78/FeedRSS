import { AuthService } from './auth.service';
import { Feed } from '../models/feed.model';
import { Channel } from '../models/channel.model';
import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';

import { Subscriber } from 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class FeedsService {
  public headers: Headers;
  private FeedsUrl: string = 'http://localhost:8080/api/rss'

  constructor(private http: Http, private auth: AuthService) {
    this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
   }

  getHomeFeeds(): Observable<Array<Channel>> {
    let data: Observable<Array<Channel>> = this.http.get(this.FeedsUrl, { headers: this.headers })
      .map(this.extractData)
      .catch(this.handleError);

    return data;
  }

  postNewFeed(url: string): Observable<Channel> {
    console.log(this.headers);
    let data: Observable<Channel> = this.http.post(this.FeedsUrl, { url: url }, { headers: this.headers })
      .map(this.extractData)
      .catch(this.handleError);

    return data;
  }
  
  deleteFeed(feed: Feed): Observable<Boolean> {
    let data: Observable<Boolean> = this.http.delete(this.FeedsUrl + '/' + feed.id, {headers: this.headers})
            .map(this.extractData)
            .catch(this.handleError);

    return data;
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

  private extractData(res: Response) {
    let body = res.json();
    return body.data || { };
  }
}
