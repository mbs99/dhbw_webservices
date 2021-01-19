package de.dhbw.dbdemo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DbDemoController {
  private DbDemoRepository repo;

  public DbDemoController(DbDemoRepository repo) {
    this.repo = repo;
  }

  @GetMapping("/api/chats")
  public List<ChatMsgEntity> getData(@RequestParam(value = "query", required = false)String query) {
    if(query != null && ! query.isEmpty()) {
      return this.repo.findByMsgContaining(query);
    } else {
      return this.repo.findAll();
    }
  }

  @PostMapping("/api/chat")
  public void createRandomMsg(@RequestBody ChatMsgEntity chatMsg) {

    this.repo.save(chatMsg);
  }
}
