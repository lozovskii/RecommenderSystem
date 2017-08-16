package com.recommendSystem.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "id_user_fk")
    private long idUserFk;

    @Column(name = "genre")
    private String genre;

    @NonNull
    @Column(name = "genre_n")
    private long genreN;

    @Column(name = "genre_reward_n")
    private Double genreRewardN;

    @Column(name = "genre_reward_plus_one")
    private Double genreRewardPlusOne;

    @Column(name = "time_learning")
    private Double timeLearning;

}