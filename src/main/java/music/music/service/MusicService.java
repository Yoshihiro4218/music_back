package music.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;

@Service
public class MusicService {
    @Autowired
    private static JdbcTemplate jdbcTemplate;

    public MusicService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public static List<Map<String, Object>> musicList(){
        List<Map<String, Object>> musicList = jdbcTemplate.queryForList("SELECT * FROM music");
        musicList.forEach(System.out::println);
        return musicList;

    }
}
