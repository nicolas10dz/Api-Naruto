package com.Aldea.Naruto.services;

import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service; // Importación duplicada (se mantiene como pediste)

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
        user.setName_team(rs.getString("name_team"));
        user.setName_lider(rs.getString("name_lider"));
        user.setName_integrante1(rs.getString("name_integrante_1"));
        user.setName_integrante2(rs.getString("name_integrante_2"));
        user.setName_integrante3(rs.getString("name_integrante_3"));

        return user;
    };

    public UsersResponseDTO createUser(UsersRequestDTO usersRequestDTO) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    UsersRepository.INSERT_USER,
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, usersRequestDTO.getName_team());
            preparedStatement.setString(2, usersRequestDTO.getName_lider());
            preparedStatement.setString(3, usersRequestDTO.getName_integrante1());
            preparedStatement.setString(4, usersRequestDTO.getName_integrante2());
            preparedStatement.setString(5, usersRequestDTO.getName_integrante3());

            return preparedStatement;
        }, keyHolder);

        UsersResponseDTO response = new UsersResponseDTO();

        // Se mantiene tu lógica de recuperación de ID y mapeo
        response.setId(keyHolder.getKey().longValue());
        response.setName_team(usersRequestDTO.getName_team());
        response.setName_lider(usersRequestDTO.getName_lider());
        response.setName_integrante1(usersRequestDTO.getName_integrante1());
        response.setName_integrante2(usersRequestDTO.getName_integrante2());
        response.setName_integrante3(usersRequestDTO.getName_integrante3());

        return response;
    }

    public List<UsersResponseDTO> getUsers() {
        // CORRECCIÓN: Cambiado de usersMapper a usersRowMapper para que coincida con tu
        // variable
        return jdbcTemplate.query(UsersRepository.GET_USERS, usersRowMapper);
    }

    public UsersResponseDTO getUser(Long id) {
        // CORRECCIÓN: Cambiado de usersMapper a usersRowMapper para que coincida con tu
        // variable
        return jdbcTemplate.queryForObject(UsersRepository.GET_USER, usersRowMapper, id);
    }

    public MessageResponseDTO deleteUser(Long id) {
        jdbcTemplate.update(UsersRepository.DELETE_USER, id);

        return new MessageResponseDTO(MessageConstants.MESSAGE_RESPONSE_DELETE_USER);
    }
}

//Listo