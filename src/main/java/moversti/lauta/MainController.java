package moversti.lauta;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import moversti.lauta.LankaRepository;

@Controller
public class MainController {

	@Autowired
	private LankaRepository lankaRepository;
	@Autowired
	private PostausRepository postausRepository;

	@GetMapping(path = "/")
	public String index(Model model) {
		model.addAttribute("langat", lankaRepository.findAll());
		return "index";
	}

	@PostMapping(path = "/")
	public RedirectView postLanka(@RequestParam String nimi, @RequestParam String op, Model model) {
		Lanka l = new Lanka();
		l.setNimi(nimi);
		ArrayList<Postaus> postaukset = new ArrayList<>();
		Postaus p = new Postaus();
		p.setContent(op);
		p = postausRepository.save(p);
		postaukset.add(p);
		l.setPostaukset(postaukset);
		l = lankaRepository.save(l);
		p.setLankaID(l.getId());
		p = postausRepository.save(p);
		return new RedirectView("/lanka/" + l.getId());
	}

	@PostMapping(path = "/lanka/{id}")
	public String postVastaus(@PathVariable("id") long id, @RequestParam String p, Model model) {
		Postaus postaus = new Postaus();
		postaus.setContent(p);
		postaus.setLankaID(id);
		postaus = postausRepository.save(postaus);
		Lanka lanka = lankaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID:" + id));
		lanka.getPostaukset().add(postaus);
		lanka = lankaRepository.save(lanka);
		model.addAttribute("lanka", lanka);
		model.addAttribute("postaukset", postausRepository.findByLankaID(lanka.getId()));
		return "lanka";
	}

	@GetMapping(path = "/lanka/{id}")
	public String showLanka(@PathVariable("id") long id, Model model) {
		Lanka lanka = lankaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID:" + id));
		model.addAttribute("lanka", lanka);
		model.addAttribute("postaukset", postausRepository.findByLankaID(lanka.getId()));
		return "lanka";
	}

}
