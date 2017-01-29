import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

import { Subscriber } from 'rxjs/Rx';
import { Observable } from "rxjs/Observable";

var xml2js = require('xml2js');

export class ValidationObject {
  constructor (
    public uri: string,
    public checkedby: string,
    public doctype: string,
    public date: string,
    public charset: string,
    public validity: string,
    public errors: {},
  ) {
  }
}

@Injectable()
export class RssValidatorService {
  private validateUrl: string = 'https://validator.w3.org/feed/check.cgi?url=';

  constructor(private http: Http) { }

  validate(feedToValidate: string): Observable<ValidationObject> {
    let url: string = this.validateUrl + feedToValidate;
    var headers = new Headers();
    var parser = new xml2js.Parser();

    headers.append('Accept', 'application/xml');

    let data = this.http.get(url, {
      headers: headers
    }).map(res => <ValidationObject>parser.parseString(res.text()));

    return data;
  }
}
