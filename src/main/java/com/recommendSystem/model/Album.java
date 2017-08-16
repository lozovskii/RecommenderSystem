package com.recommendSystem.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NonNull
    @Column(name = "id_user_fk")
    private long idUserFk;

    @NonNull
    @Column(name = "album")
    private String album;

    @NonNull
    @Column(name = "album_n")
    private long albumN;

    @NonNull
    @Column(name = "album_reward_n")
    private Double albumRewardN;

    @NonNull
    @Column(name = "album_reward_plus_one")
    private Double albumRewardPlusOne;

    @NonNull
    @Column(name = "time_learning")
    private Double timeLearning;

}
