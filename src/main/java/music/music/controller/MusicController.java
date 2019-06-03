package music.music.controller;

import lombok.extern.slf4j.Slf4j;
import music.music.form.MusicCreateForm;
import music.music.service.MusicService;
import org.springframework.beans.BeanUtils;
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
    @GetMapping("/musics")
    @ResponseBody
    public List<Map<String, Object>> getMusic(){
        return MusicService.musicList();
    }

    @GetMapping("/musics/{id}")
    @ResponseBody
    public List<Map<String, Object>> showMusic(@PathVariable("id") int musicId){
        return MusicService.showMusic(musicId);
    }

    @PostMapping("/musics")
    @ResponseBody
    public void createMusic(@Validated MusicCreateForm form){
        MusicService.insertMusicData(form);

    }
    @DeleteMapping("/musics/{id}")
    @ResponseBody
    public void deleteMusic(@PathVariable("id") int musicId){
        MusicService.deleteMusic(musicId);
    }

    @PutMapping("/musics/{id}")
    @ResponseBody
    public void updateMusic(@PathVariable("id") int musicId, MusicCreateForm form){
        MusicService.updateMusicData(form, musicId);
    }
}