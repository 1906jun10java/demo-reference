import { Component, OnInit } from '@angular/core';

import { Hero } from '../models/hero'
import { HEROES } from '../models/mock-heroes';

@Component({
  selector: 'app-heroes', // by convention, selectors are named [module-name]-[component-name]
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  constructor() { }

  heroes = HEROES;

  selectedHero: Hero;
    
  onSelect(hero: Hero): void {
    this.selectedHero = hero;
  }

  ngOnInit() {
  }

}
