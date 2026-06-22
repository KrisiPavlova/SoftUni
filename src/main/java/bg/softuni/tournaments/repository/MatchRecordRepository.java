package bg.softuni.tournaments.repository;
import bg.softuni.tournaments.model.entity.MatchRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MatchRecordRepository extends JpaRepository<MatchRecord, UUID> {}