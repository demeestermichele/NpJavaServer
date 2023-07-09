package com.dione.npjavaserver.dto;

import java.io.Serializable;

/**
 * A combined DTO for the {@link com.dione.npjavaserver.model.Chapter} and {@link com.dione.npjavaserver.model.Charac} entities
 */
public class SearchDTO implements Serializable {
    private Long characterId;
    private String characterName;
    private Long chapterId;
    private String chapterName;
    private Long plotId;
    private String plotName;

    public SearchDTO() {
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

    public Long getPlotId() {
        return plotId;
    }

    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    @Override
    public String toString() {
        return "CharacterChapterPlotDTO{" +
                "characterId=" + characterId +
                ", characterName='" + characterName + '\'' +
                ", chapterId=" + chapterId +
                ", chapterName='" + chapterName + '\'' +
                ", plotId=" + plotId +
                ", plotName='" + plotName + '\'' +
                '}';
    }
}
