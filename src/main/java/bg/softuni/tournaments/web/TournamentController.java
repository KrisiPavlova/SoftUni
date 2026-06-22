package bg.softuni.tournaments.web;

import bg.softuni.tournaments.model.entity.Tournament;
import bg.softuni.tournaments.service.TournamentService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
@RequestMapping("/tournaments")
public class TournamentController {
    private final TournamentService tournamentService;
    public TournamentController(TournamentService tournamentService) { this.tournamentService = tournamentService; }

    @GetMapping("/add")
    public String addTournamentForm(Model model, HttpSession session) {
        if (session.getAttribute("user_id") == null) return "redirect:/auth/login";
        if (!model.containsAttribute("tournament")) model.addAttribute("tournament", new Tournament());
        return "add-tournament";
    }

    @PostMapping("/add")
    public String addTournament(@Valid @ModelAttribute("tournament") Tournament tournament, BindingResult result, HttpSession session) {
        if (session.getAttribute("user_id") == null) return "redirect:/auth/login";
        if (result.hasErrors()) return "add-tournament";
        tournamentService.createTournament(tournament);
        return "redirect:/tournaments/all";
    }

    @GetMapping("/all")
    public String allTournaments(Model model, HttpSession session) {
        if (session.getAttribute("user_id") == null) return "redirect:/auth/login";
        model.addAttribute("tournaments", tournamentService.getAllTournaments());
        return "all-tournaments";
    }

    @PostMapping("/delete/{id}")
    public String deleteTournament(@PathVariable UUID id, HttpSession session) {
        if (session.getAttribute("user_id") == null) return "redirect:/auth/login";
        tournamentService.deleteTournament(id);
        return "redirect:/tournaments/all";
    }
}