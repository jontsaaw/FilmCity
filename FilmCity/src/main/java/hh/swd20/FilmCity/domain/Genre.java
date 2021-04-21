package hh.swd20.FilmCity.domain;

import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	 @JsonIgnoreProperties("genre")
	  private List<Movie> movies;

	
	public Genre() {
		super();
		this.name = null;
	}
	
	public Genre(String name) {
		super();
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		
		return this.name;
	}
}
