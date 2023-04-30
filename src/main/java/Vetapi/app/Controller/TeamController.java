package Vetapi.app.Controller;

import Vetapi.app.Model.Team;
import Vetapi.app.Model.TeamDTO;
import Vetapi.app.Service.TeamService;
import jakarta.annotation.Nonnull;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipo")
public class TeamController {

    @Autowired
    private TeamService ts;

    @PostMapping("/add")
    public ResponseEntity addTeam(@RequestBody final Team t){
        return ts.addTeam(t);

    }
    @PostMapping("{id}/delete")
    public ResponseEntity delTeam(@RequestBody final @NotNull Integer id){
        return ts.deleteTeam(id);
    }
    @PostMapping("{id}/update")
    public ResponseEntity updateTeam(@PathVariable final @Nonnull Integer id, @RequestBody  final Team t){
        return ts.updateTeam(id, t);
    }
    @GetMapping("/getAll")
    public List<TeamDTO> getAll(){
        return ts.getAll();
    }
    @GetMapping("/{id}")
    public TeamDTO getTeam(@PathVariable final Integer id){
        return ts.getTeam(id);
    }
}
