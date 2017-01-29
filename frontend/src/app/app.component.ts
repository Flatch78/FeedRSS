import { FeedsService } from './shared/services/feeds.service';
import { Component } from '@angular/core';
import { AuthService } from './shared/services/auth.service';

import { CookieService } from 'angular2-cookie/services/cookies.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})

export class AppComponent {
  constructor(private auth: AuthService, private cookieService: CookieService, private feeds: FeedsService) {
  }
}
