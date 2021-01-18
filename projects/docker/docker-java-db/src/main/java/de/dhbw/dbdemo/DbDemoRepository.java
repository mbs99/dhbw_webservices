package de.dhbw.dbdemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DbDemoRepository extends JpaRepository<ChatMsgEntity, Integer> {
}
