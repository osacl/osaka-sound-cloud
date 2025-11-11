package com.osaka.osakasoundcloud.service;

import com.osaka.osakasoundcloud.dto.MusicRequest;
import com.osaka.osakasoundcloud.dto.MusicResponse;
import com.osaka.osakasoundcloud.entity.Music;
import com.osaka.osakasoundcloud.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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

    public MusicResponse findById(Long id) {
        Music music = musicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 음악 ID입니다. id:" + id));
        return MusicResponse.from(music);
    }

    @Transactional
    public void updateMusic(Long id, MusicRequest musicRequest) {
        Music music = musicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 번호 입니다. id:" + id));
        music.updateMusic(
                musicRequest.getTitle(),
                musicRequest.getArtist(),
                musicRequest.getAlbum(),
                musicRequest.getReleaseDate(),
                musicRequest.getGenre(),
                musicRequest.getComments());
    }

    @Transactional
    public void deleteMusic(Long id) {
        Music music = musicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 번호 입니다. id:" + id));
        musicRepository.delete(music);
    }
}
