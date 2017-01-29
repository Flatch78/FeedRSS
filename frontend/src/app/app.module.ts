import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing } from './app-routing.module';

import { RssValidatorService } from './shared/services/rss-validator.service';
import { AuthService } from './shared/services/auth.service';
import { AuthGuard } from './guards/auth.guard';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { FeedsService } from './shared/services/feeds.service';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';
import { AccountComponent } from './account/account.component';
import { FeedComponent } from './feed/feed.component';
import { ModalComponent } from './modal/modal.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    AccountComponent,
    FeedComponent,
    ModalComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    routing
  ],
  providers: [AuthService, AuthGuard, CookieService, RssValidatorService, FeedsService],
  bootstrap: [AppComponent]
})

export class AppModule { }
