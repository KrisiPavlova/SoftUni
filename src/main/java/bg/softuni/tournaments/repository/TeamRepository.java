package bg.softuni.tournaments.repository;
import bg.softuni.tournaments.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
    boolean existsByName(String name);
}