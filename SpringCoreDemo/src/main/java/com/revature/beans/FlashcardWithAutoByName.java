package com.revature.beans;

public class FlashcardWithAutoByName extends Flashcard {
	
	public FlashcardWithAutoByName(int id, String question, String answer, FlashcardTopic topic) {
		super(id, question, answer, topic);
	}

	public FlashcardWithAutoByName() {
		super();
	}

	// this flashcard will need an Author
	private Author author;

	public Author getAuthor() {
		return author;
	}

	// this is where the Author will be set
	// must match name of the dependency
	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "FlashcardWithAutoByName [ id=" + this.getId() + ", question=" + this.getQuestion() + ", answer="
				+ this.getAnswer() + ", topic=" + this.getTopic() + ", author=" + author + "]";
	}


}
