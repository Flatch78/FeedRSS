import { Channel } from '../shared/models/channel.model';
import { environment } from '../../environments/environment.prod';
import { IFeed, Feed } from '../shared/models/feed.model';
import { FeedsService } from '../shared/services/feeds.service';
import { FeedComponent } from '../feed/feed.component';
import { routing } from '../app-routing.module';
import { RssValidatorService } from '../shared/services/rss-validator.service';
import { AuthService } from '../shared/services/auth.service';
import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ModalComponent } from '../modal/modal.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})

export class HomeComponent implements OnInit {
  @ViewChild(ModalComponent) modal: ModalComponent;
  homeFeeds: Array<Feed>;
  homeChannels: Array<Channel>;
  test: Feed;
  feedSearch: string;

  constructor(private auth: AuthService, private router: Router, private feeds: FeedsService, private validator: RssValidatorService) { }

  ngOnInit() {
    this.homeFeeds = new Array<Feed>();

    this.homeFeeds.push(new Feed({  
      author: "Jean Paul",
      id: "fefezzze",
      title: "Test numero 1",
      publishedDate: "24 mars 2018",
      description: "fjezfjzeof zfozofz eofzkzofkzz",
      category: "test",
      url: "http://www.melty.fr/la-villa-des-coeurs-brises-2-episode-28-ce-soir-martika-seule-contre-tous-melanie-craque-et-fond-en-larmes-a582146.html",
      urlImage: "http://www.w3schools.com/css/trolltunga.jpg"
    }));

    this.test = this.homeFeeds.pop();

    var data = this.feeds.getHomeFeeds();
    
    data.subscribe(
      data => {
        this.homeChannels = data
      },
      err => {

      }
    );
  }

  logout(event: Event): void {
    event.preventDefault();
    this.auth.logout();
    this.router.navigate(['/login']);
  }

  newFeeds(channelUrl: string) {
    var data = this.feeds.postNewFeed(channelUrl);

    data.subscribe(
      data => {
        this.homeChannels.push(data);
      },
      err => {

      }
    )
  }

  onKey(event: any) {
    this.feedSearch = event.target.value;
    if (event.keyCode === 13) {
      //var data = this.validator.validate(this.feedSearch);

      /*data.subscribe(
        data => {
          if (data.validity === 'true') {*/
            this.newFeeds(this.feedSearch)
        /* }
        },
        err => {

        }
      );*/
    }
  }

}
