package de.dhbw.dbdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DbDemoController {
  private DbDemoRepository repo;

  public DbDemoController(DbDemoRepository repo) {
    this.repo = repo;
  }

  @GetMapping("/api/chats")
  public List<ChatMsgEntity> getData() {
    return this.repo.findAll();
  }

  @PostMapping("/api/chat")
  public void createRandomMsg(@RequestBody ChatMsgEntity chatMsg) {

    this.repo.save(chatMsg);
  }
}
