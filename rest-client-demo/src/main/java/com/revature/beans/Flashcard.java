package com.revature.beans;

public class Flashcard {

	public Flashcard(int id, String question, String answer, FlashcardTopic topic, Author author) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.topic = topic;
		this.author = author;
	}

	public Flashcard() {
		super();
	}

	private int id;
	private String question;
	private String answer;
	private FlashcardTopic topic;
	private Author author;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public FlashcardTopic getTopic() {
		return topic;
	}

	public void setTopic(FlashcardTopic topic) {
		this.topic = topic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + ", topic=" + topic
				+ ", author=" + author + "]";
	}

}
