package hh.swd20.FilmCity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.FilmCity.domain.Genre;
import hh.swd20.FilmCity.domain.GenreRepository;
import hh.swd20.FilmCity.domain.Movie;
import hh.swd20.FilmCity.domain.MovieRepository;

@SpringBootApplication
public class FilmCityApplication {
	private static final Logger log = LoggerFactory.getLogger(FilmCityApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FilmCityApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(MovieRepository movieRepository, GenreRepository genreRepository) {
	return (args) -> {
		log.info("save some sample genres");
		Genre genre1 = new Genre("Comedy");
		Genre genre2 = new Genre("Horror");
		Genre genre3 = new Genre("Action");
		Genre genre4 = new Genre("Musical");
		
		genreRepository.save(genre1);
		genreRepository.save(genre2);
		genreRepository.save(genre3);
		genreRepository.save(genre4);
		

		
		log.info("fetch all genres");
		for (Genre genre : genreRepository.findAll()) {
			log.info(genre.toString());
		}
		
		log.info("save a couple of genres");
		
		
		Movie movie1 = new Movie("Game Night", 3.59, 2018, 6.9, genre1);
		Movie movie2 = new Movie("Get Out", 2.99, 2017, 7.7, genre2);
		Movie movie3 = new Movie("Dreamgirls", 1.90, 2006, 6.5, genre4);
		
		movieRepository.save(movie1);
		movieRepository.save(movie2);	
		movieRepository.save(movie3);
		

		log.info("fetch all movies");
		for (Movie movie : movieRepository.findAll()) {
			log.info(movie.toString());
		}
		
		
	};
	}
}
