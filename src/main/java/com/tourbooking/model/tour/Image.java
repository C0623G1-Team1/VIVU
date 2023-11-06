package com.tourbooking.model.tour;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "LONGTEXT")
    private String url;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id", referencedColumnName = "tour_id")
    private Tour tour;


    public Image(String url, Tour tour) {
        this.url = url;
        this.tour = tour;
    }
}
