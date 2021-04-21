package hh.swd20.FilmCity.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.FilmCity.domain.Genre;
import hh.swd20.FilmCity.domain.GenreRepository;


@Controller
public class GenreController {
@Autowired
private GenreRepository genreRepository;

@GetMapping("/genrelist")
public String genrelist(Model model) {
	model.addAttribute("genres", (List<Genre>) genreRepository.findAll());
	return "genres";
}

@GetMapping("/addgenre")
public String addGenre(Model model) {
    model.addAttribute("genre", new Genre());
    return "addgenre";
}

@PostMapping("/addgenre")
public String saveGenre(@ModelAttribute Genre genre) {
	genreRepository.save(genre);
	return "redirect:genrelist";
}

@RequestMapping(value="/genres", method = RequestMethod.GET)
public @ResponseBody List<Genre> getGenreRest() {	
    return (List<Genre>) genreRepository.findAll();
}    


@RequestMapping(value="/genres/{id}", method = RequestMethod.GET)
public @ResponseBody Optional<Genre> findGenreRest(@PathVariable("id") Long genreId) {	
	return genreRepository.findById(genreId);
} 


@RequestMapping(value="/genres", method = RequestMethod.POST)
public @ResponseBody Genre saveGenreRest(@RequestBody Genre genre) {	
	return genreRepository.save(genre);
}
}