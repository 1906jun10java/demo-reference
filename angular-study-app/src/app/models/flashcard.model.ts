import { Author } from './author.model';

export class Flashcard {
    id: number;
    question: String;
    answer: String;
    topic: String;
    author: Author;

    constructor(id: number, question: String, answer: String, topic: String, author: Author) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.topic = topic;
        this.author = author;
    }
}