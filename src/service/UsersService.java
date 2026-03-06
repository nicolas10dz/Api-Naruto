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











}

