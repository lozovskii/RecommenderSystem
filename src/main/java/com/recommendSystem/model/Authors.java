package com.recommendSystem.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "authors")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "id_user_fk")
    private long idUserFk;

    @Column(name = "author")
    private String author;

    @NonNull
    @Column(name = "author_n")
    private long authorN;

    @Column(name = "author_reward_n")
    private Double authorRewardN;

    @Column(name = "author_reward_plus_one")
    private Double authorRewardPlusOne;

    @Column(name = "time_learning")
    private Double timeLearning;

}