import { Component, OnInit } from '@angular/core';
import { FlashcardService } from '../../services/flashcard-service';
import { Flashcard } from '../../models/flashcard.model';
import { FormGroup, FormControl } from '@angular/forms';
import { Author } from '../../models/author.model';

@Component({
    selector: 'app-flashcard-demo',
    templateUrl: './flashcard-demo.component.html',
    styleUrls: ['./flashcard-demo.component.css']
})
export class FlashcardDemoComponent implements OnInit {

    public flashcards: Flashcard[];
    form = new FormGroup({
        card: new FormGroup({
            question: new FormControl(''),
            answer: new FormControl(''),
            topic: new FormControl('')
        }),
        author: new FormGroup({
            firstName: new FormControl(''),
            lastName: new FormControl('')
        })
    });

    public submitFlashcard(): void {
        // call method in flashcardService which uses HttpClient to perform a POST request to backend
        let newCard = this.form.value.card;
        let newAuthor = this.form.value.author;
        let flashcard = new Flashcard(0, newCard.question, newCard.answer, newCard.topic, new Author(0, newAuthor.firstName, newAuthor.lastName));
        this.flashcardService.createFlashcard(flashcard).subscribe(
            res => this.flashcards.push(flashcard),
            error => console.log(error)
        );
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