import { Feed } from './feed.model';
export interface IChannel {
    id: string;
    title: string;
    url: string;
    description: string;
    icon: string;
    feedrss?: Array<Feed>;
    author?: string;
    publishedDate?: string;
    enclosure?: string;
    source?: string;
    guid?: string;
    category?: string;
    urlImage?: string;
    comment?: string
}

export class Channel implements IChannel {
    id: string;
    title: string;
    url: string;
    description: string;
    icon: string;
    feedrss?: Array<Feed>;
    author?: string;
    publishedDate?: string;
    enclosure?: string;
    source?: string;
    guid?: string;
    category?: string;
    urlImage?: string;
    comment?: string;

    constructor(channel: IChannel)
    {
        this.id = channel.id;
        this.title = channel.title;
        this.url = channel.url;
        this.description = channel.description;
        this.icon = channel.icon;
        this.author = channel.author;
        this.publishedDate = channel.publishedDate;
        this.enclosure = channel.enclosure;
        this.source = channel.source;
        this.guid = channel.guid;
        this.category = channel.category;
        this.urlImage = channel.urlImage;
        this.feedrss = channel.feedrss;
        this.comment = channel.comment;
    }
}