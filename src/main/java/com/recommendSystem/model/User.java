package com.recommendSystem.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User implements Serializable{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Id
    @NonNull
    @Column(name = "imei")
    private long imei;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Song> songs;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Track> tracks;

}