import { Component, OnInit } from '@angular/core';
import { FlashcardService } from '../../services/flashcard-service';
import { Flashcard } from '../../models/flashcard.model';

@Component({
    selector: 'app-flashcard-demo',
    templateUrl: './flashcard-demo.component.html',
    styleUrls: ['./flashcard-demo.component.css']
  })
export class FlashcardDemoComponent implements OnInit {

    public flashcards: Flashcard[]; 

    // Inject service
    // in a typescript constructor, can define properties of the class
    constructor(private flashcardService: FlashcardService) { }


    ngOnInit(): void {
       this.flashcardService.fetchAllFlashcards().subscribe(
           cardList => this.flashcards = cardList,
           error => console.log(error)     
        );
    }

}