package com.recommendSystem.model;

import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_activ")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long songId;

    @NotNull
    @Column(name = "imei_fk")
    private long imeiFk;

    @NotNull
    @Column(name = "song_date")
    private String songDate;

    @NotNull
    @Column(name = "song_name_artist")
    private String songNameArtist;

    @NotNull
    @Column(name = "song_name")
    private String songName;

    @NotNull
    @Column(name = "song_name_album")
    private String songNameAlbum;

    @NotNull
    @Column(name = "song_name_genre")
    private String songNameGenre;

    @NotNull
    @Column(name = "song_name_author")
    private String songNameAuthor;

    @NotNull
    @Column(name = "song_duration")
    private int songDuration;

    @NotNull
    @Column(name = "song_status")
    private int songStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "imei_fk", referencedColumnName = "imei", insertable=false, updatable=false)
    private User tuser;

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", imeiFk=" + imeiFk +
                ", songDate='" + songDate + '\'' +
                ", songNameArtist='" + songNameArtist + '\'' +
                ", songName='" + songName + '\'' +
                ", songNameAlbum='" + songNameAlbum + '\'' +
                ", songNameGenre='" + songNameGenre + '\'' +
                ", songNameAuthor='" + songNameAuthor + '\'' +
                ", songDuration=" + songDuration +
                ", songStatus=" + songStatus +
                '}';
    }
}