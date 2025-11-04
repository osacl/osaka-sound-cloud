package com.osaka.osakasoundcloud.service;

import com.osaka.osakasoundcloud.dto.MusicResponse;
import com.osaka.osakasoundcloud.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MusicService {

    private final MusicRepository musicRepository;

//    public List<MusicResponse> findAll() {
//        List<Music> musics = musicRepository.findAll();
//
//        List<MusicResponse> musicResponses = new ArrayList<>();
//        for (Music music : musics) {
//            musicResponses.add(MusicResponse.from(music));
//        }
//
//        return musicResponses;
//    }

    public List<MusicResponse> findAll() {
        return musicRepository.findAll()
                .stream()
                //.map(music -> MusicResponse.from(music))
                .map(MusicResponse::from)
                .toList();
    }
}
