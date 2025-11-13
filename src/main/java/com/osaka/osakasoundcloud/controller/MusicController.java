package com.osaka.osakasoundcloud.controller;

import com.osaka.osakasoundcloud.dto.MusicRequest;
import com.osaka.osakasoundcloud.dto.MusicResponse;
import com.osaka.osakasoundcloud.entity.Music;
import com.osaka.osakasoundcloud.service.MusicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/musics")
@RequiredArgsConstructor
@RestController
public class MusicController {

    private final MusicService musicService;

    // 전체 조회 -
    @GetMapping
    public ResponseEntity<List<MusicResponse>> findAll() {
        return ResponseEntity.ok(musicService.findAll());
    }

    // 상세 조회
//    @GetMapping("/{id}")
//    public ResponseEntity<MusicResponse> findById(@PathVariable Long id) {
//        Music music = musicService.findById(id);
//        return ResponseEntity.ok(MusicResponse.from(music));
//    }

    //  등록
    @PostMapping
    public ResponseEntity<MusicResponse> create(@RequestBody MusicRequest musicRequest) {
        MusicResponse musicResponse = musicService.save(musicRequest);
        return ResponseEntity.ok(musicResponse);
    }
}
