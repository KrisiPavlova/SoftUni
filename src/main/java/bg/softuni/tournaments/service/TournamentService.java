package bg.softuni.tournaments.service;

import bg.softuni.tournaments.model.entity.Tournament;
import bg.softuni.tournaments.repository.TournamentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public void createTournament(Tournament tournament) { tournamentRepository.save(tournament); }
    public List<Tournament> getAllTournaments() { return tournamentRepository.findAll(); }
    public void deleteTournament(UUID id) { tournamentRepository.deleteById(id); }
}