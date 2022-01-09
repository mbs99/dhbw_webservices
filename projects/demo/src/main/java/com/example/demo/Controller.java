package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class Controller {
    MetaRepo metaRepo;
    PlaylistRepo playlistRepo;
    PlaylistMetaRepo playlistMetaRepo;
    public Controller(MetaRepo metaRepo, PlaylistRepo playlistRepo,
            PlaylistMetaRepo playlistMetaRepo) {
        this.metaRepo = metaRepo;
        this.playlistRepo = playlistRepo;
        this.playlistMetaRepo = playlistMetaRepo;
    }

    @GetMapping("init")
    public void init() {

        Playlist playlist = new Playlist();
        playlist = this.playlistRepo.save(playlist);

        PlaylistMeta playlistMeta = new PlaylistMeta();
        playlistMeta.playlist = playlist;
        playlistMeta = this.playlistMetaRepo.save(playlistMeta);

        Meta meta = new Meta();
        meta.album = "My Test";
        meta.playlistMeta = playlistMeta;
        meta = this.metaRepo.save(meta);

        Meta meta2 = new Meta();
        meta2.album = "My Dummy";
        meta2.playlistMeta = playlistMeta;
        meta2 = this.metaRepo.save(meta2);

        playlistMeta.metadata.add(meta);
        playlistMeta.metadata.add(meta2);
        this.playlistMetaRepo.save(playlistMeta);
    }

    @GetMapping("query")
    public List<Meta> query() {

        List<Meta> meta = this.metaRepo.findAll();
        List<PlaylistMeta> playlistMeta = this.playlistMetaRepo.findAll();

        meta = this.metaRepo.customQuery(1L, "test");
        meta = this.metaRepo.customQuery2("test");
        meta = this.metaRepo.findByAlbumIgnoreCaseContaining("test");
        return meta;
    }
}
