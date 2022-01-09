package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="playlist")
public class Playlist {
    @Id
    @GeneratedValue
    Long id;
}
