export interface IFeed {
    id: string;
    title: string;
    url: string;
    description: string;
    author?: string;
    publishedDate?: string;
    urlImage?: string;
    source?: string;
    guid?: string;
    category?: string;
}

export class Feed implements IFeed {
    id: string;
    title: string;
    url: string;
    description: string;
    author?: string;
    publishedDate?: string;
    urlImage?: string;
    source?: string;
    guid?: string;
    category?: string;

    constructor(feed: IFeed) {
        this.id = feed.id;
        this.title = feed.title;
        this.url = feed.url;
        this.description = feed.description;
        this.author = feed.author;
        this.publishedDate = feed.publishedDate;
        this.urlImage = feed.urlImage;
        this.source = feed.source;
        this.guid = feed.guid;
        this.category = feed.category;
    }
}