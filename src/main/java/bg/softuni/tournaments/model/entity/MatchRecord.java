package bg.softuni.tournaments.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name = "match_records")
public class MatchRecord {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "team_one_id")
    private Team teamOne;
    @ManyToOne(optional = false)
    @JoinColumn(name = "team_two_id")
    private Team teamTwo;
    @NotBlank(message = "Резултатът е задължителен")
    @Column(nullable = false)
    private String result;

    public MatchRecord() {}
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Team getTeamOne() { return teamOne; }
    public void setTeamOne(Team teamOne) { this.teamOne = teamOne; }
    public Team getTeamTwo() { return teamTwo; }
    public void setTeamTwo(Team teamTwo) { this.teamTwo = teamTwo; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}