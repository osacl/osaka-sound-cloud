package com.osaka.osakasoundcloud.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Data
public class MusicRequest {

    private String title;
    private String artist;
    private String album;
    private LocalDate releaseDate;
    private String genre;
    private String comments;


}
