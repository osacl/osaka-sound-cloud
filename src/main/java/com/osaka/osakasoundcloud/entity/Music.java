package com.osaka.osakasoundcloud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "musics")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String artist;

    @Column(nullable = false, length = 100)
    private String album;

    private LocalDateTime releaseDate;

    @Column(nullable = false, length = 100)
    private String genre;

    @Lob // @Lob을 붙이면 JPA가 자동으로 해당 DB에 맞는 대용량 문자 타입(CLOB or TEXT)으로 매핑합니다.
    @Column(nullable = true)
    private String comments;
}
