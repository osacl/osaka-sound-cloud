package com.osaka.osakasoundcloud.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class MusicRequest {

    private String title;
    private String artist;
    private String album;
    private LocalDate releaseDate;
    private String genre;
    private String comments;
}
