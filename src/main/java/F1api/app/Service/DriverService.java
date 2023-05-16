package F1api.app.Service;

import F1api.app.Model.Driver;
import F1api.app.Model.DriverDTO;
import F1api.app.Repository.DriverRepository;
import F1api.app.Repository.TeamRepository;
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
public class DriverService {
    private final DriverRepository dr;
    private final TeamService ts;
    private final ModelMapper mm = new ModelMapper();
    @Autowired
    public DriverService(DriverRepository dr, TeamService ts){
        this.dr = dr;
        this.ts = ts;
    }
    public ResponseEntity addDriver(Driver d, Integer teamId){
        try{
            d.setTeam(ts.getTeam(teamId));
            dr.save(d);
            return ResponseEntity.status(CREATED).build();
        }
        catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity deleteDriver(Integer id){

        try{
            dr.deleteById(id);
            return ResponseEntity.status(OK).build();
        }catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity updateDriver(Integer id, Driver d) {

        try{
            Driver dd = dr.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Piloto no encontrado"));
            dd.setId(d.getId());
            dd.setName(d.getName());
            dd.setLastName(d.getLastName());
            dd.setAge(d.getAge());
            dd.setPosition(d.getPosition());
            dd.setCarNumber(d.getCarNumber());
            dd.setNationality(d.getNationality());
            dr.save(dd);
            return ResponseEntity.status(OK).build();
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
    public DriverDTO getDriver(int id){
        Driver d = dr.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Piloto no encontrado"));
        return mm.map(d, DriverDTO.class);
    }

    public List<DriverDTO> getAll(){
        List<Driver> drivers = dr.findAll();
        List<DriverDTO> driversdto = new ArrayList<DriverDTO>();
        for(Driver d : drivers){
            driversdto.add(mm.map(d,DriverDTO.class));
        }
        return driversdto;
    }

    public List<DriverDTO> getDriverxTeam(String nameTeam){
        List<DriverDTO> driversxteam = new ArrayList<>();

        for(DriverDTO d : getAll()){
            if(d.getTeam().getName().equals(nameTeam)){
                driversxteam.add(d);
            }
        }
        return driversxteam;
    }
}
