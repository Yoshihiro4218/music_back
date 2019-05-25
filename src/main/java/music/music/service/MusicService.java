package music.music.service;

import music.music.form.MusicCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;
import java.util.List;

@CrossOrigin
@Service
public class MusicService {
    @Autowired
    private static JdbcTemplate jdbcTemplate;

    public MusicService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public static List<Map<String, Object>> musicList() {
        List<Map<String, Object>> musicList = jdbcTemplate.queryForList("SELECT * FROM music");
        musicList.forEach(System.out::println);
        return musicList;
    }

    public static void insertMusicData(MusicCreateForm data) {
        System.out.println(data.getAlbumName());

//        String sql = "INSERT INTO music (music_name, artist_name, album_name) VALUES (?, ?, ?)";
//        jdbcTemplate.update(sql, new Object[]{
//                data.get("music_name"),
//                data.get("artist_name"),
//                data.get("album_name")
//        });
    }
}