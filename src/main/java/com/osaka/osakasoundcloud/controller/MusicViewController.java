package com.osaka.osakasoundcloud.controller;

import com.osaka.osakasoundcloud.dto.MusicResponse;
import com.osaka.osakasoundcloud.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/musics")
public class MusicViewController {

    private final MusicService musicService;

    @GetMapping
    public String musicList(Model model){
        List<MusicResponse> musics = musicService.findAll();
        model.addAttribute("musics", musics);
        return "musicList";
    }
    @GetMapping("/{id}")
    public String musicEach(@PathVariable Long id, Model model){
        MusicResponse music = musicService.findById(id);
        model.addAttribute("music", music);
        return "musicEach";
    }
}
