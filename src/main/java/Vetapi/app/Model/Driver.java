package Vetapi.app.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;
@Data
@AllArgsConstructor
@Entity
public class Driver {
    @NotNull
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
    @JoinColumn(name = "team_id")
    private Team team;
}
