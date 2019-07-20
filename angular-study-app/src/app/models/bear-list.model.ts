import { Bear } from './bear.model';

export class BearList {
    bears: Bear[];

    constructor(bears: Bear[]) {
        this.bears = bears;
    }
}
