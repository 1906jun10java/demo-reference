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
    public flashcardToCreate: Flashcard = {
        id: 1998,
        question: "What do badgers eat?",
        answer: "Everything",
        topic: "THE_BEATLES",
        author: {
            id: 835,
            firstName: "Sun",
            lastName: "Flash"
        }
    }

    public submitFlashcard(): void {
        // call method in flashcardService which uses HttpClient to perform a POST request to backend
    }

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