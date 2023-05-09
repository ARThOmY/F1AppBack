package F1api.app.Service;

import F1api.app.Model.Team;
import F1api.app.Repository.TeamRepository;
import F1api.app.Model.TeamDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class TeamService {
    private final TeamRepository tr;
    private final ModelMapper mm = new ModelMapper();
    @Autowired
    public TeamService(TeamRepository tr){
        this.tr = tr;
    }
    public ResponseEntity addTeam(Team t){

        try{
            tr.save(t);
            return ResponseEntity.status(CREATED).build();
        }
        catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();

        }
    }
    public ResponseEntity deleteTeam(Integer id){

        try{
            tr.deleteById(id);
            return ResponseEntity.status(OK).build();
        }catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity updateTeam(Integer id, Team t) {

        try{
            Team tt = tr.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Equipo no encontrado"));
            tt.setId(t.getId());
            tt.setName(t.getName());
            tt.setCar(t.getCar());
            tt.setLocation(t.getLocation());
            tt.setPosition(t.getPosition());
            tr.save(tt);
            return ResponseEntity.status(OK).build();
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
    public TeamDTO getTeam(int id){
        Team t = tr.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Equipo no encontrado"));
        return mm.map(t, TeamDTO.class);
    }

    public List<TeamDTO> getAll(){
        List<Team> teams = tr.findAll();
        List<TeamDTO> teamsdto = new ArrayList<TeamDTO>();
        for(Team t : teams){
            teamsdto.add(mm.map(t,TeamDTO.class));
        }
        return teamsdto;
    }
}
