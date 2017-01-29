import { FeedsService } from '../shared/services/feeds.service';
import { AuthService } from '../shared/services/auth.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators  } from '@angular/forms';

import { CookieService } from 'angular2-cookie/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less']
})

export class LoginComponent implements OnInit {
  complexForm : FormGroup;

  constructor(private auth: AuthService, fb: FormBuilder, private router: Router, private cookieService: CookieService, private feeds: FeedsService){
    this.complexForm = fb.group({
      'name' : [null, Validators.required],
      'password': [null, Validators.required]
    })
  }

  submitForm(value){
    var data = this.auth.login(value.name, value.password);

    data.subscribe(
      data => {
        this.auth.user.id = data.id;
        this.auth.user.name = data.name;
        this.auth.user.token = data.token;
        this.auth.user.rss = data.rss;
        this.cookieService.put('access_token', this.auth.user.token);
        this.feeds.headers.append('token', this.auth.user.token);
        console.log(this.feeds.headers);
        this.router.navigate(['home']);
      },
      err => {

      }
    );
  }

  ngOnInit() {
  }

}
