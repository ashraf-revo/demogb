package com.example.entities

import javax.persistence.Entity
import javax.persistence.Id


@Entity
class Chatter {
    String name
    @Id
    String chatId
}
