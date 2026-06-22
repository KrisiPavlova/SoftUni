package bg.softuni.tournaments.repository;
import bg.softuni.tournaments.model.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TournamentRepository extends JpaRepository<Tournament, UUID> {}