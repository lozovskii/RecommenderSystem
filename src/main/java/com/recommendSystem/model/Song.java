package com.recommendSystem.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user_activ")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long songId;

    @Column(name = "imei")
    private long imei;

    @Column(name = "song_date")
    private String songDate;

    @Column(name = "song_name_artist")
    private String songNameArtist;

    @Column(name = "song_name")
    private String songName;

    @Column(name = "song_name_album")
    private String songNameAlbum;

    @Column(name = "song_name_genre")
    private String songNameGenre;

    @Column(name = "song_name_author")
    private String songNameAuthor;

    @Column(name = "song_duration")
    private int songDuration;

    @Column(name = "song_status")
    private int songStatus;

}