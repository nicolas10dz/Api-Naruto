package com.Aldea.Naruto.services;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;




import com.Aldea.Naruto.constants.MessageConstants;
import com.Aldea.Naruto.dto.MessageResponseDTO;
import com.Aldea.Naruto.dto.UsersResponseDTO;
import com.Aldea.Naruto.dto.UsersRequestDTO;
import com.Aldea.Naruto.repository.UsersRepository;


@Service
public class UsersService {


    private JdbcTemplate jdbcTemplate;

    public UsersService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    }


private final RowMapper<UsersResponseDTO> usersRowMapper = (rs, rowNum) -> {

UsersResponseDTO user = new UsersResponseDTO();
user.setId(rs.getLong("id"));
user.setnombre(rs.getString("nombre_equipo"));
user.setName(rs.getString("lider_equipo"));
user.setEmail(rs.getString("integrante_1"));
user.setEmail(rs.getString("integrante_2"));
user.setEmail(rs.getString("integrante_3"));

return userResponseDTO;
};


    public UsersResponseDTO createUser(UsersRequestDTO usersRequestDTO) {
        // Objeto para capturar el ID autoincremental generado por el motor de BD
        // (MySQL/PostgreSQL, etc.)
        KeyHolder keyHolder = new GeneratedKeyHolder();
                // update se usa para insert, update, delete
        jdbcTemplate.update(connection -> {
            // Preparamos la sentencia usando la constante SQL y pedimos que devuelva las
            // llaves generadas
            PreparedStatement preparedStatement = connection.prepareStatement(
                    UsersRepository.INSERT_USER,
                    Statement.RETURN_GENERATED_KEYS);

                    
            // Sustituimos los "?" de la consulta por valores reales
            preparedStatement.setString(1, usersRequestDTO.getName_());
            preparedStatement.setString(2, usersRequestDTO.getEmail());
            preparedStatement.setString(3, usersRequestDTO.getPhone());
            preparedStatement.setString(4, usersRequestDTO.getAddress());

            return preparedStatement;
        }, keyHolder); // El keyHolder se llena con la información del nuevo ID


                // con la informacion del nuevo usuario creado
        UsersResponseDTO response = new UsersResponseDTO();
        response.setId(keyHolder.getKey().longValue());
        response.setName_team(usersRequestDTO.getName_team());
        response.setName_lider(usersRequestDTO.getName_lider());
        response.setName_integrante1(usersRequestDTO.getName_integrante1());
        response.setName_integrante2(usersRequestDTO.getName_integrante2());
        response.setName_integrante3(usersRequestDTO.getName_integrante3());

        // Retornamos el DTO con la información del nuevo usuario creado al controller
        return response;
    }



    public List<UsersResponseDTO> getUsers() {
        return jdbcTemplate.query(UsersRepository.GET_USERS, usersMapper);
    }

    public UsersResponseDTO getUser(Long id) {
        return jdbcTemplate.queryForObject(UsersRepository.GET_USER, usersMapper, id);
    }

    public MessageResponseDTO deleteUser(Long id) {
        jdbcTemplate.update(UsersRepository.DELETE_USER, id);

        MessageResponseDTO response = new MessageResponseDTO();
        response.setMessage(MessageConstants.MESSAGE_RESPONSE_DELETE_USER);

        return response;
    }
}