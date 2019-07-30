package com.revature.beans;

public class FlashcardWithAutoByType extends Flashcard {
	
	public FlashcardWithAutoByType(int id, String question, String answer, FlashcardTopic topic) {
		super(id, question, answer, topic);
	}

	public FlashcardWithAutoByType() {
		super();
	}

	// this flashcard will need an Author
	private Author author;

	public Author getAuthor() {
		return author;
	}

	// this is where the Author will be set
	// must match datatype of an available dependency
	public void setAuthorOrWhatever(Author authorOrWhateverItDoesntMatter) {
		this.author = authorOrWhateverItDoesntMatter;
	}

	@Override
	public String toString() {
		return "FlashcardWithAutoByType [ id=" + this.getId() + ", question=" + this.getQuestion() + ", answer="
				+ this.getAnswer() + ", topic=" + this.getTopic() + ", author=" + author + "]";
	}

}
