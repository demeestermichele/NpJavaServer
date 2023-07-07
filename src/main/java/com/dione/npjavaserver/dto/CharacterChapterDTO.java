package com.dione.npjavaserver.dto;

import java.io.Serializable;

/**
 * A combined DTO for the {@link com.dione.npjavaserver.model.Chapter} and {@link com.dione.npjavaserver.model.Charac} entities
 */
public class CharacterChapterDTO implements Serializable {
    private Long characterId;
    private String characterName;
    private Long chapterId;
    private String chapterName;

    public CharacterChapterDTO() {
    }

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    @Override
    public String toString() {
        return "CharacterChapterDTO{" +
                "characterId=" + characterId +
                ", characterName='" + characterName + '\'' +
                ", chapterId=" + chapterId +
                ", chapterName='" + chapterName + '\'' +
                '}';
    }
}
