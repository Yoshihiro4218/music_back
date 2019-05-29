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
    @GetMapping(value = "/musics")
    @ResponseBody
    public List<Map<String, Object>> getMusicList(){
        return MusicService.musicList();
    }

    @PostMapping("/musics")
    @ResponseBody
    public void postMusic(@Validated MusicCreateForm form){
        MusicService.insertMusicData(form);

    }
}