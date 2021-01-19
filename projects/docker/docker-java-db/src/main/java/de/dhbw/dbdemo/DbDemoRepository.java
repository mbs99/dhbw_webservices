package de.dhbw.dbdemo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DbDemoRepository extends JpaRepository<ChatMsgEntity, Integer> {

    List<ChatMsgEntity> findByMsgContaining(String query);
    List<ChatMsgEntity> findByMsgContainingIgnoreCase(String query);
    List<ChatMsgEntity> findByMsgContainingIgnoreCaseOrNameContainingIgnoreCase(String query);
}
