package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class PlaylistMeta {
    @Id
    @GeneratedValue
    public Long id;

    @OneToMany(mappedBy="playlistMeta")
    public Set<Meta> metadata = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "playlist_id", referencedColumnName = "id")
    public Playlist playlist;
}
