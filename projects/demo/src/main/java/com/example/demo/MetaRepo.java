package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface MetaRepo extends JpaRepository<Meta, Long> {

    @Query("Select m from Meta m where m.playlistMeta.playlist.id = :playlistId and lower(m.album) like lower(concat('%', :album,'%'))")
    List<Meta> customQuery(@Param("playlistId")Long playlistId, @Param("album")String album);

    @Query("Select m from Meta m where upper(m.album) like upper(concat('%', :album,'%'))")
    List<Meta> customQuery2(@Param("album") String album);

    List<Meta> findByAlbumIgnoreCaseContaining(String album);

}
