package music.music.service;

import music.music.form.MusicCreateForm;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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


    public List<Map<String, Object>> musicList() {
        List<Map<String, Object>> musicList = jdbcTemplate.queryForList("SELECT * FROM music");
        musicList.forEach(System.out::println);
        return musicList;
    }

    public List<Map<String, Object>> showMusic(int musicId) {
        List<Map<String, Object>> musicDetail = jdbcTemplate.queryForList("SELECT * FROM music WHERE id = ?", musicId);
        musicDetail.forEach(System.out::println);
        return musicDetail;
    }

    public void insertMusicData(MusicCreateForm data) {
        String sql = "INSERT INTO music (music_name, artist_name, album_name) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                data.getMusicName(),
                data.getArtistName(),
                data.getAlbumName()
        );
    }

    public void deleteMusic(int musicId){
        String sql = "DELETE FROM music WHERE id = ?";
        jdbcTemplate.update(sql, musicId);
    }

    public void updateMusicData(MusicCreateForm data, int musicId) {
        String sql = "UPDATE music SET music_name = ?, artist_name = ?, album_name = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                data.getMusicName(),
                data.getArtistName(),
                data.getAlbumName(),
                musicId
        );
    }

    public List<Map<String, Object>> sortMusicList(String sortCondition){
        String sql = "SELECT * FROM music ORDER BY " + sortCondition;
        List<Map<String, Object>> musicList = jdbcTemplate.queryForList(sql);
        musicList.forEach(System.out::println);
        System.out.println(sortCondition);
        return musicList;
    }

    public int goodCountUp(int musicId){
        int currentGoodNum;
        int updatedGoodNum;

        currentGoodNum = jdbcTemplate.queryForObject("SELECT good FROM music WHERE id = ?", int.class, musicId);
        updatedGoodNum = currentGoodNum + 1;
        jdbcTemplate.update("UPDATE music SET good = ? WHERE id = ?", updatedGoodNum, musicId);

        return updatedGoodNum;
    }
}