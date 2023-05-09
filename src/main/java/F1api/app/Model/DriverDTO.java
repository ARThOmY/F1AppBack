package F1api.app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {
    private String Name;
    private String LastName;
    private int Age;
    private int Position;
    private int CarNumber;
    private String Nationality;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamDTO team;
}
