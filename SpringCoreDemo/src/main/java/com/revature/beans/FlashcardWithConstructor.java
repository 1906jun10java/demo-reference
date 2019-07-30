package com.revature.beans;

public class FlashcardWithConstructor extends Flashcard {

	public FlashcardWithConstructor(Author author) {
		this();
		this.author = author;
	}

	public FlashcardWithConstructor() {
	}

	private Author author;

	public Author getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "FlashcardWithConstructor [id=" + this.getId() + ", question=" + this.getQuestion() + ", answer="
				+ this.getAnswer() + ", topic=" + this.getTopic() + ", author=" + author + "]";
	}

}
