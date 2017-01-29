import { RssFeedAggregatorPage } from './app.po';

describe('rss-feed-aggregator App', function() {
  let page: RssFeedAggregatorPage;

  beforeEach(() => {
    page = new RssFeedAggregatorPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
