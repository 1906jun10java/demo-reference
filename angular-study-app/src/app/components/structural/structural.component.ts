import { Component } from '@angular/core';

@Component({
  selector: 'app-structural',
  templateUrl: './structural.component.html',
  styleUrls: ['./structural.component.css']
})
export class StructuralComponent {
  title = 'Structural Directive';
  documentation = 'https://angular.io/guide/structural-directives';

  public flashcards = [
    {
      question: 'What is the answer to life, the universe, and everything?',
      answer: '42'
    },
    {
      question: 'What is the question?',
      answer: 'What is six times eight?'
    },
    {
      question: 'What is the airspeed velocity of an unladen swallow?',
      answer: 'African or European swallow?'
    },
    {
      question: 'How much wood could a woodchuck chuck?',
      answer: '7.'
    }
  ];
}
