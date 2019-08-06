import { Injectable } from '@angular/core';
import { Flashcard } from '../models/flashcard.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class FlashcardService {

    private baseUrl: String = "http://localhost:8082/flashcard";
    private flashcards: Flashcard[];

    private dummyFlashcards = [
        {
            id: 1,
            question: "What is the question?",
            answer: "What is six times eight?",
            topic: "THE_BEATLES",
            author: {
                id: 835,
                firstName: "Sun",
                lastName: "Flash"
            }
        },
        {
            id: 189,
            question: "Of which state is the badger the state animal?",
            answer: "Wisconsin",
            topic: "THE_BEATLES",
            author: {
                id: 835,
                firstName: "Sun",
                lastName: "Flash"
            }
        },
        {
            id: 777,
            question: "What animal represents Hufflepuff?",
            answer: "Badger",
            topic: "CODING",
            author: {
                id: 800,
                firstName: "Tom",
                lastName: "Badgeron"
            }
        },
        {
            id: 999,
            question: "When do badgers sleep?",
            answer: "In the daytime",
            topic: "BEARS",
            author: {
                id: 835,
                firstName: "Sun",
                lastName: "Flash"
            }
        },
        {
            id: 1003,
            question: "Do they care?",
            answer: "NO",
            topic: "CODING",
            author: {
                id: 877,
                firstName: "The",
                lastName: "HoneyBadger"
            }
        },
        {
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
      ];

    constructor(private http: HttpClient) {
    }

    public fetchAllFlashcards(): Observable<Flashcard[]> {
        return this.http.get<Flashcard[]>(this.baseUrl+"/all");
    }

}