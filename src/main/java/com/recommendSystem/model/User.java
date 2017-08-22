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
@Table(name = "tuser")
public class User implements Serializable{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Id
    @NonNull
    @Column(name = "imei")
    private long imei;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tuser")
    private Set<Song> songs;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tuser")
    private Set<Track> tracks;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", imei=" + imei +
                '}';
    }
}