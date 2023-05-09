package F1api.app.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
    private String Name;
    private String Car;
    private String Location;
    private int Position;

    @OneToMany(mappedBy = "driverDTO")
    @JsonIgnore
    private List<DriverDTO> driverList;
}
