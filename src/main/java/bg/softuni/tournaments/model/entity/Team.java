package bg.softuni.tournaments.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "teams")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank(message = "Името е задължително.")
    @Size(min = 3, max = 30, message = "Между 3 и 30 символа.")
    @Column(nullable = false, unique = true)
    private String name;
    @NotBlank(message = "Играта е задължителна.")
    @Column(nullable = false)
    private String game;

    public Team() {}
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGame() { return game; }
    public void setGame(String game) { this.game = game; }
}