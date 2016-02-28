package com.example.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.example.entities.Chatter
import com.example.util.Constants

@Service
class ChatterService {
    @Autowired
    ChatterRepository chatterRepository

    def newChatter(String name, String chatId) {

        chatterRepository.save(new Chatter(name: name, chatId: chatId))
    }

    def deleteChatter(String chatId) {
        chatterRepository.delete(chatId)
    }

    Collection<Chatter> getAllChatters() {
        chatterRepository.findAll()
    }

    boolean serverOnline() {

        def allChatters = getAllChatters().collect { it.chatId }
        Constants.SERVER_CHAT_ID in getAllChatters().collect { it.chatId }
    }

    boolean readyForChat() {
        serverOnline() && getAllChatters().size() == 1
    }
}
