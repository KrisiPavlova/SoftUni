package bg.softuni.tournaments.service;

import bg.softuni.tournaments.model.entity.Team;
import bg.softuni.tournaments.repository.TeamRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    public TeamService(TeamRepository teamRepository) { this.teamRepository = teamRepository; }

    public void createTeam(Team team) {
        if (teamRepository.existsByName(team.getName())) {
            throw new IllegalArgumentException("Отбор с това име вече съществува!");
        }
        teamRepository.save(team);
    }
    public List<Team> getAllTeams() { return teamRepository.findAll(); }
    public void deleteTeam(UUID id) { teamRepository.deleteById(id); }
}