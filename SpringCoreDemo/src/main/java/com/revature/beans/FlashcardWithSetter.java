package com.revature.beans;

public class FlashcardWithSetter extends Flashcard {

	public FlashcardWithSetter(int id, String question, String answer, FlashcardTopic topic) {
		super(id, question, answer, topic);
	}

	public FlashcardWithSetter() {
		super();
	}

	// this flashcard will need an Author
	private Author author;

	public Author getAuthor() {
		return author;
	}

	// this is where the Author will be set
	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "FlashcardWithSetter [ id=" + this.getId() + ", question=" + this.getQuestion() + ", answer="
				+ this.getAnswer() + ", topic=" + this.getTopic() + ", author=" + author + "]";
	}

}
