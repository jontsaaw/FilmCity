package hh.swd20.FilmCity.web;


import hh.swd20.FilmCity.domain.GenreRepository;
import hh.swd20.FilmCity.domain.Movie;
import hh.swd20.FilmCity.domain.MovieRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@CrossOrigin
@Controller

public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private GenreRepository genreRepository;
	
	
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public String getMovies (Model model) {
		List<Movie> movies = (List<Movie>) movieRepository.findAll();
		model.addAttribute("movies", movies);
		return "movies";
	

}
	
		@RequestMapping(value = "/addmovie", method = RequestMethod.GET)
		public String getNewMovieForm(Model model) {
			model.addAttribute("movie", new Movie()); 
			model.addAttribute("genres", genreRepository.findAll());
			return "addmovie";
		}

		
		@RequestMapping(value = "/savemovie", method = RequestMethod.POST)
		public String saveMovie(@ModelAttribute Movie movie) {
			
			movieRepository.save(movie);
			return "redirect:/movies";
		}

		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		@PreAuthorize("hasRole('ADMIN')")
		
		public String deleteMovie(@PathVariable("id") Long id) {
			movieRepository.deleteById(id);
			return "redirect:../movies";
		}
		
		@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		@PreAuthorize("hasRole('ADMIN')")
		
		public String editMovie(@PathVariable("id") Long id, Model model) {
			model.addAttribute("movie", movieRepository.findById(id).get());
			model.addAttribute("genres", genreRepository.findAll());
			return "editmovie";
		}
		
		@RequestMapping(value="/films", method = RequestMethod.GET)
		public @ResponseBody List<Movie> MovieListRest() {	
		        return (List<Movie>) movieRepository.findAll();
		    }    
		
		@RequestMapping(value="/films/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Movie> findMovieRest(@PathVariable("id") Long movieId) {	
	    	return movieRepository.findById(movieId);
	    }      
		
		@RequestMapping(value="/movies", method = RequestMethod.POST)
	    public @ResponseBody Movie saveMovieRest(@RequestBody Movie movie) {	
	    	return movieRepository.save(movie);
	    }
		
		@RequestMapping(value="/login")
		public String login() {
			return "login";
		}    
	}