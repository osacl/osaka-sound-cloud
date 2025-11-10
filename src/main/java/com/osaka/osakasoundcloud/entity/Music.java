package com.osaka.osakasoundcloud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "musics")
public class Music extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String artist;

    @Column(nullable = false, length = 100)
    private String album;

    private LocalDate releaseDate;

    @Column(nullable = false, length = 100)
    private String genre;

    @Lob // @Lob을 붙이면 JPA가 자동으로 해당 DB에 맞는 대용량 문자 타입(CLOB or TEXT)으로 매핑합니다.
    @Column(nullable = true)
    private String comments;

    public void updateMusic(String title,
                            String artist,
                            String album,
                            LocalDate releaseDate,
                            String genre,
                            String comments) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.comments = comments;
    }
}
