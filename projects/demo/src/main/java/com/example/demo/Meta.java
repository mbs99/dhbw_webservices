package com.example.demo;

import javax.persistence.*;

@Entity
public class Meta {
    @Id
    @GeneratedValue
    public Long id;

    @Column(name="album", nullable = false)
    public String album;

    @ManyToOne
    @JoinColumn(name="playlist_meta_id", nullable=false)
    public PlaylistMeta playlistMeta;
}
