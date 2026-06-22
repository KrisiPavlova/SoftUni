package bg.softuni.tournaments.web;

import bg.softuni.tournaments.model.entity.Team;
import bg.softuni.tournaments.service.TeamService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;
    public TeamController(TeamService teamService) { this.teamService = teamService; }

    @GetMapping("/add")
    public String addTeamForm(Model model, HttpSession session) {
        if (session.getAttribute("user_id") == null) return "redirect:/auth/login";
        if (!model.containsAttribute("team")) model.addAttribute("team", new Team());
        return "add-team";
    }

    @PostMapping("/add")
    public String addTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, HttpSession session) {
        if (session.getAttribute("user_id") == null) return "redirect:/auth/login";
        if (result.hasErrors()) return "add-team";
        teamService.createTeam(team);
        return "redirect:/teams/all";
    }

    @GetMapping("/all")
    public String allTeams(Model model, HttpSession session) {
        if (session.getAttribute("user_id") == null) return "redirect:/auth/login";
        model.addAttribute("teams", teamService.getAllTeams());
        model.addAttribute("role", session.getAttribute("user_role"));
        return "all-teams";
    }

    @PostMapping("/delete/{id}")
    public String deleteTeam(@PathVariable UUID id, HttpSession session) {
        if (session.getAttribute("user_id") == null) return "redirect:/auth/login";
        if (!"ADMIN".equals(session.getAttribute("user_role"))) {
            throw new IllegalArgumentException("Нямате права да изтривате отбори!");
        }
        teamService.deleteTeam(id);
        return "redirect:/teams/all";
    }
}