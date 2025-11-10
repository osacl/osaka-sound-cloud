package com.osaka.osakasoundcloud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.osaka.osakasoundcloud.entity.Music;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
public class MusicResponse {

    private Long id;
    private String title;
    private String artist;
    private String album;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private String genre;
    private String comments;
    private LocalDateTime createdDate;

    public static MusicResponse from(Music music) {
        return MusicResponse.builder()
                .id(music.getId())
                .title(music.getTitle())
                .artist(music.getArtist())
                .album(music.getAlbum())
                .releaseDate(music.getReleaseDate())
                .genre(music.getGenre())
                .comments(music.getComments())
                .createdDate(music.getCreatedDate())
                .build();
    }
}
