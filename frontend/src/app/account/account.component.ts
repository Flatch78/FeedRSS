import { AuthService } from '../shared/services/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.less']
})
export class AccountComponent implements OnInit {

  constructor(private auth: AuthService) { }

  ngOnInit() {
  }

}
