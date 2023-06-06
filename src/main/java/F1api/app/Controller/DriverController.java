package F1api.app.Controller;

import F1api.app.Model.Driver;
import F1api.app.Model.DriverDTO;
import F1api.app.Service.DriverService;
import jakarta.annotation.Nonnull;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Piloto")
@CrossOrigin(origins="*")
public class DriverController {

    @Autowired
    private DriverService ds;

    @PostMapping("/{teamid}/add")
    public ResponseEntity addDriver(@RequestBody final Driver d, @PathVariable final Integer teamid){
        return ds.addDriver(d, teamid);

    }
    @PostMapping("/{id}/delete")
    public ResponseEntity delDriver(@PathVariable final @NotNull Integer id){
        return ds.deleteDriver(id);
    }
    @PostMapping("/{id}/{team_id}/update")
    public ResponseEntity updDriver(@PathVariable final @NotNull Integer id, @RequestBody  final Driver d, @PathVariable final @NotNull Integer team_id){
        return ds.updateDriver(id, d,team_id);
    }
    @GetMapping("/getAll")
    public List<DriverDTO> getAll(){
        return ds.getAll();
    }
    @GetMapping("/{id}")
    public DriverDTO getDriver(@PathVariable final Integer id){
        return ds.getDriver(id);
    }

    @GetMapping("/getDriversTeam/{teamName}")
    public List<DriverDTO> getDriverTeam(@PathVariable final String teamName){
        return ds.getDriverxTeam(teamName);
    }
}
