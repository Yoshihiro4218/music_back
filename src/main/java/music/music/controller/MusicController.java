package music.music.controller;

import music.music.service.MusicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.List;

@RestController
public class MusicController {
    @RequestMapping(value = "/music", method = RequestMethod.GET)
    public List<Map<String, Object>> index(){
        return MusicService.musicList();
    }
}