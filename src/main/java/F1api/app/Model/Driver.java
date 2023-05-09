package F1api.app.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Name;
    private String LastName;
    private int Age;
    private int Position;
    private int CarNumber;
    private String Nationality;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "team_id")
    private Team team;
}
