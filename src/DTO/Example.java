package DTO;

import java.io.Serializable;
import java.util.ArrayList;

public class Example implements Serializable {
	String title;
	String singer;
	String genre;
	public ArrayList<String> test = new ArrayList<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
