package com.eeds.monolitica.proyect.repositories.jdbc.implement;

import com.eeds.monolitica.proyect.dto.UserRolDTO;
import com.eeds.monolitica.proyect.dto.UserRolUpdateDTO;
import com.eeds.monolitica.proyect.repositories.jdbc.UserRolJdbcRepository;
import com.eeds.monolitica.proyect.repositories.jdbc.implement.row.mapper.UserRolRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRolJdbcRepositoryImpl implements UserRolJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRolJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserRolDTO> listUsersRoles() {
        var sql = """
                SELECT id,active,user_id,rol_id
                FROM user_rol;
                """;
        return jdbcTemplate.query(sql,new UserRolRowMapper());
    }

    @Override
    public int save(UserRolDTO userRolDTO) {
        var sql= """
                INSERT INTO user_rol (id,active,created_at, user_id,rol_id)
                VALUES (nextval('user_rol_sequence'),?,CURRENT_TIMESTAMP,?,?);
                """;
        return jdbcTemplate.update(sql, userRolDTO.getActive(),userRolDTO.getUserId(),userRolDTO.getRolId());
    }

    @Override
    public int updateStatus(Long userId, Integer rolId, UserRolUpdateDTO userRolUpdateDTO) {
        var sql= """
                UPDATE user_rol
                SET active = ?
                WHERE user_id = ?
                  AND rol_id = ?;
                """;
        return jdbcTemplate.update(sql,userRolUpdateDTO.getActive(),userId,rolId);
    }
}
