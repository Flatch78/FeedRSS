import { FeedsService } from '../shared/services/feeds.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../shared/services/auth.service';
import { FormGroup, FormBuilder, Validators  } from '@angular/forms';

import { CookieService } from 'angular2-cookie/core';

@Component({
  selector: 'app-signup',
  providers: [AuthService],
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.less']
})
export class SignupComponent implements OnInit {
  complexForm : FormGroup;

  matchingPasswords(passwordKey: string, passwordConfirmationKey: string) {
      return (group: FormGroup) => {
        let passwordInput = group.controls[passwordKey];
        let passwordConfirmationInput = group.controls[passwordConfirmationKey];
        if (passwordInput.value !== passwordConfirmationInput.value) {
          return passwordConfirmationInput.setErrors({notEquivalent: true})
        }
    }
  }

  constructor(private auth: AuthService, fb: FormBuilder, private cookieService: CookieService, private router: Router, private feeds: FeedsService){
    var emailRegex = '^[a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,15})$'
    var passwordMinLength = 5;
    this.complexForm = fb.group({
      'password': [null, Validators.compose([Validators.required, Validators.minLength(passwordMinLength)])],
      'confirmPassword': [null, Validators.compose([Validators.required, Validators.minLength(passwordMinLength)])],
      'name': [null, Validators.required]
    }, {validator: this.matchingPasswords('password', 'confirmPassword')})
  }

  submitForm(value){
    var data = this.auth.signup(value.name, value.password);

    data.subscribe(
      data => {
        this.auth.user.token = data.token;
        this.cookieService.put('access_token', this.auth.user.token);
        this.feeds.headers.append("token", this.auth.user.token)
        this.router.navigate(['home']);
      },
      err => {
        
      }
    );
  }
  
  ngOnInit() {
  }

}
