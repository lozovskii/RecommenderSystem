package com.recommendSystem.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tracks")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NonNull
    @Column(name = "id_user_fk")
    private long idUserFk;

    @NonNull
    @Column(name = "track_n")
    private long trackN;

    @NonNull
    @Column(name = "track_date")
    private String trackDate;

    @NonNull
    @Column(name = "track_name_artist")
    private String trackNameArtist;

    @NonNull
    @Column(name = "track_name")
    private String trackName;


    @Column(name = "track_reward_n")
    private Double trackRewardN;


    @Column(name = "track_reward_plus_one")
    private Double trackRewardPlusOne;


    @Column(name = "time_learning")
    private Double timeLearning;

}