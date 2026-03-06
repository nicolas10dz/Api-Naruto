package com.Aldea.Naruto.repository;

public class UsersRepository {

    public static final String INSERT_USER = "INSERT INTO users (name_team, name_lider, name_integrante_1, name_integrante_2, name_integrante_3) VALUES (?, ?, ?, ?, ?)";

    public static final String GET_USERS = "SELECT * FROM users";

    public static final String GET_USER = "SELECT * FROM users WHERE id = ?";

    public static final String DELETE_USER = "DELETE FROM users WHERE id = ?";

}
// DB
