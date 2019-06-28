package music.music.controller;

import lombok.extern.slf4j.Slf4j;
import music.music.form.MusicCreateForm;
import music.music.service.MusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.List;

@CrossOrigin
@Controller
@Slf4j
public class MusicController {
    @Autowired
    MusicService musicService;

    @GetMapping("/musics")
    @ResponseBody
    public List<Map<String, Object>> getMusic(){
        return musicService.musicList();
    }

    @GetMapping("/musics/{id}")
    @ResponseBody
    public List<Map<String, Object>> showMusic(@PathVariable("id") int musicId){
        return musicService.showMusic(musicId);
    }

    @PostMapping("/musics")
    @ResponseBody
    public void createMusic(@Validated MusicCreateForm form){
        musicService.insertMusicData(form);

    }
    @DeleteMapping("/musics/{id}")
    @ResponseBody
    public void deleteMusic(@PathVariable("id") int musicId){
        musicService.deleteMusic(musicId);
    }

    @PutMapping("/musics/{id}")
    @ResponseBody
    public void updateMusic(@PathVariable("id") int musicId, MusicCreateForm form){
        musicService.updateMusicData(form, musicId);
    }

    @GetMapping("/musics/sort")
    @ResponseBody
    public List<Map<String, Object>> sortMusic(@RequestParam String condition){
        return musicService.sortMusicList(condition);
    }

    @PostMapping("/musics/{id}/good")
    @ResponseBody
    public int goodCountUp(@PathVariable("id") int musicId){
        return musicService.goodCountUp(musicId);
    }
}