package de.dhbw.dbdemo;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "chats")
public class ChatMsgEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;

    @Column(name = "msg")
    public String msg;

    @Column(name = "name")
    public String user;

    @Column(name = "channel")
    public String channel;
}
