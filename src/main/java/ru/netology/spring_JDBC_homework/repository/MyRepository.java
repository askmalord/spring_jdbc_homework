package ru.netology.spring_JDBC_homework.repository;

import com.zaxxer.hikari.pool.HikariProxyCallableStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MyRepository {
    private static final String SCRIPT_FILE_NAME = "data.sql";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MyRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {
        String queryResult = namedParameterJdbcTemplate.queryForObject(read(SCRIPT_FILE_NAME),
                Map.of("name", name), String.class);
        return queryResult;
    }
}
