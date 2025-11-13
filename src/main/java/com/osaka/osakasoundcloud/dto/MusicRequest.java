package com.osaka.osakasoundcloud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.osaka.osakasoundcloud.entity.Music;
import lombok.Data;
import java.time.LocalDate;

@Data
public class MusicRequest {

    private String title;

    private String artist;

    private String album;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    private String genre;

    private String comments;

    public Music toEntity() {
        return Music.builder()
                .title(title)
                .artist(artist)
                .album(album)
                .releaseDate(releaseDate)
                .genre(genre)
                .comments(comments)
                .build();
    }
}
