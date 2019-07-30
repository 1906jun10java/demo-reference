package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // stereotype which marks class as a Spring bean, default name for the bean is
			// going to be componentScannedFlashcard
@Scope(value = "prototype")
public class ComponentScannedFlashcard extends Flashcard {

	public ComponentScannedFlashcard(int id, String question, String answer, FlashcardTopic topic) {
		super(id, question, answer, topic);
	}

	public ComponentScannedFlashcard() {
		super();
	}

	// this flashcard will need an Author
	// @Autowired no! field injection! just use the setter or constructor
	private Author author;

	public Author getAuthor() {
		return author;
	}

	// this is where the Author will be set
	@Autowired // allows IoC container to identify dependencies it needs to fill
	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "ComponentScannedFlashcard [ id=" + this.getId() + ", question=" + this.getQuestion() + ", answer="
				+ this.getAnswer() + ", topic=" + this.getTopic() + ", author=" + author + "]";
	}

}
