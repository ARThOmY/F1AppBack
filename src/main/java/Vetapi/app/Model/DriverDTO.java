package Vetapi.app.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;
@Data
@AllArgsConstructor
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
