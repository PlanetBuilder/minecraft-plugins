package de.planetbuilder.customizedchat.data;

public class CCPlayerData {
    String name;
    String joinMessagePrefix;
    String joinMessageSuffix;
    String quitMessage;
    String chatStyle;

    public String getJoinMessagePrefix() {
        return joinMessagePrefix;
    }

    public void setJoinMessagePrefix(String joinMessagePrefix) {
        this.joinMessagePrefix = joinMessagePrefix;
    }

    public String getJoinMessageSuffix() {
        return joinMessageSuffix;
    }

    public void setJoinMessageSuffix(String joinMessageSuffix) {
        this.joinMessageSuffix = joinMessageSuffix;
    }
}
