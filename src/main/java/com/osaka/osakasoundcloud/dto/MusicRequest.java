package com.osaka.osakasoundcloud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.osaka.osakasoundcloud.entity.Music;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class MusicRequest {

    @NotBlank(message = "제목은 필수 입력값입니다.")
    private String title;

    @NotBlank(message = "아티스트는 필수 입력값입니다.")
    private String artist;

    @NotBlank(message = "앨범명은 필수 입력값입니다.")
    private String album;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @NotBlank(message = "장르를 선택해주세요.")
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
