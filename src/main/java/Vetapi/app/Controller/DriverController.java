package Vetapi.app.Controller;

import Vetapi.app.Model.Driver;
import Vetapi.app.Model.DriverDTO;
import Vetapi.app.Model.Team;
import Vetapi.app.Model.TeamDTO;
import Vetapi.app.Service.DriverService;
import Vetapi.app.Service.TeamService;
import jakarta.annotation.Nonnull;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Piloto")
public class DriverController {

    @Autowired
    private DriverService ds;

    @PostMapping("/add")
    public ResponseEntity addTeam(@RequestBody final Driver d){
        return ds.addDriver(d);

    }
    @PostMapping("{id}/delete")
    public ResponseEntity delTeam(@RequestBody final @NotNull Integer id){
        return ds.deleteDriver(id);
    }
    @PostMapping("{id}/update")
    public ResponseEntity updateTeam(@PathVariable final @Nonnull Integer id, @RequestBody  final Driver d){
        return ds.updateDriver(id, d);
    }
    @GetMapping("/getAll")
    public List<DriverDTO> getAll(){
        return ds.getAll();
    }
    @GetMapping("/{id}")
    public DriverDTO getDriver(@PathVariable final Integer id){
        return ds.getDriver(id);
    }

    @GetMapping("/getDriversTeam")
    public List<DriverDTO> getDriverTeam(@PathVariable final String teamName){
        return ds.getDriverxTeam(teamName);
    }
}