package com.osaka.osakasoundcloud.controller;

import com.osaka.osakasoundcloud.dto.MusicResponse;
import com.osaka.osakasoundcloud.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/musics")
@RequiredArgsConstructor
@RestController
public class MusicController {

    private final MusicService musicService;

    // 전체 조회
    @GetMapping
    public ResponseEntity<List<MusicResponse>> findAll() {
        return ResponseEntity.ok(musicService.findAll());
    }
}
