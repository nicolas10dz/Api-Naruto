import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.Aldea.Naruto.dto.MessageResponseDTO;
import com.Aldea.Naruto.dto.UsersRequestDTO;
import com.Aldea.Naruto.dto.UsersResponseDTO;
import com.Aldea.Naruto.services.UsersService;

public class UsersControllers {

    @RestController
    @RequestMapping("/users")
    public class UsersController {


        private final UsersService usersService;
        //Inyeccion de dependencias


        public UsersController(UsersService usersService) {
            this.usersService = usersService;
        }


        @PostMapping()
        public ResponseEntity <UsersRequestDto> createUser(@RequestBody UsersRequestDTO usersRequestDto){

            UserResponseDTO response = usersService.createUser(usersRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);


        }

        @GetMapping()
    public ResponseEntity <List<UsersResponseDTO>> getUsers(){
    List<UsersResponseDTO> response = usersService.getUser();
    return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity <UsersResponseDTO> getUser(@PathVariable Long id){
        UsersResponseDTO response = usersService.getUser(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <MessageResponseDTO> deleteUser(@PathVariable Long id){
        MessageResponseDTO response = usersService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    
        

    
    }

    }
}
