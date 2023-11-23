package com.eeds.monolitica.proyect.repositories.jdbc.implement.row.mapper;

import com.eeds.monolitica.proyect.dto.UserRolDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRolRowMapper implements RowMapper<UserRolDTO> {
    @Override
    public UserRolDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserRolDTO(
                rs.getInt("id"),
                rs.getBoolean("active"),
                rs.getLong("user_id"),
                rs.getInt("rol_id")
        );
    }
}
