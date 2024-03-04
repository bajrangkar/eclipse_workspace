package mosh.streams;

public class MovieGenre {
	private String title;
	private int likes;
	private Genre genre;
	public MovieGenre(String title, int likes, Genre genre) {
		this.title = title;
		this.likes = likes;
		this.genre = genre;
	}
	public String getTitle() {
		return title;
	}
	public int getLikes() {
		return likes;
	}
	public Genre getGenre() {
		return genre;
	}
}

enum Genre {
	COMEDY,
	ACTION,
	THRILLER
}
