import { Channel } from './channel.model';
export interface IUser {
    id: string;
    name: string;
    token: string;
    rss: Array<Channel>;
}

export class User implements IUser {
    id: string;
    name: string;
    token: string;
    rss: Array<Channel>;

    constructor() {
        this.id = '';
        this.name = '';
        this.token = '';
        this.rss = new Array<Channel>();
    }
}
