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
public class Team {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Name;
    private String Car;
    private String Location;
    private int Position;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Driver> driverList;
}
