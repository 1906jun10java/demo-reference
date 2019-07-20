import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core'; // this gives us the NgModule decorator
import { FormsModule } from '@angular/forms'; // this gives us the ngModel attribute for two-way databinding

import { AppComponent } from './app.component';
import { HeroesComponent } from './heroes/heroes.component';

@NgModule({
  // list of components 
  declarations: [
    AppComponent,
    HeroesComponent
  ],
  // other dependencies which the app is using
  imports: [
    BrowserModule,
    FormsModule
  ],
  // list of injectable services
  providers: [],
  // which component to initialize at application start
  bootstrap: [AppComponent]
})
export class AppModule { }
/*
  Creating a TypeScript class and naming it AppModule
  Adding NgModule decorator - provides some meta-programming about the class
  Which indicates that AppModule is an Angular module (different than the TS modules we discussed)
*/
