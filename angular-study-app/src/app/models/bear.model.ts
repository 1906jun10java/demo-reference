import { Cave } from './cave.model';
import { BearType } from './bear-type.model';

export class Bear {
    id: number;
    name: string;
    cave: Cave;
    bearType: BearType;
    weight: number;
    birthdate: Date;

    constructor(id: number, name: string, cave: Cave, type: BearType, weight: number, birthdate: Date ) {
        this.id = id;
        this.name = name;
        this.cave = cave;
        this.bearType = type;
        this.weight = weight;
        this.birthdate = birthdate;
    }
}
