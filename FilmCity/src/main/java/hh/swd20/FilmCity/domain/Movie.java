package hh.swd20.FilmCity.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private double price;
	private int year;
	private double imdb;
	
	
	@ManyToOne
	@JsonIgnoreProperties ("movies")
	@JoinColumn(name = "genreId")
	private Genre genre;
	
	public Movie() {
		super();
		this.title = null;
		this.price = 0;
		this.year = 0;
		this.imdb = 0;
		this.genre = null;
	}

	

	public Movie(String title, double price, int year, double imdb, Genre genre) {
		super();
		this.title = title;
		this.price = price;
		this.year = year;
		this.imdb = imdb;
		this.genre = genre;
	}



	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getImdb() {
		return imdb;
	}
	public void setImdb(double imdb) {
		this.imdb = imdb;
	}

	@Override
	public String toString() {
		return   title + ", " + price + ", " + year + ", " + imdb + ", " + genre;
	}
	
	
	
}
