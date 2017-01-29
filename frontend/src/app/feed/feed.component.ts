import { RssValidatorService } from '../shared/services/rss-validator.service';
import { FeedsService } from '../shared/services/feeds.service';
import { Component, OnInit, Input } from '@angular/core';
import { IFeed, Feed } from '../shared/models/feed.model';

@Component({
  selector: 'feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.less']
})

export class FeedComponent implements OnInit {
  @Input() content: Feed;

  constructor() {
  }

  ngOnInit() {
  }

  openFeed() {
    window.open(this.content.url);
  }
}
