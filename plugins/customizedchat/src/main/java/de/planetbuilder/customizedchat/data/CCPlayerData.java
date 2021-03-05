package de.planetbuilder.customizedchat.data;

public class CCPlayerData {
    String joinMessagePrefix;
    String joinMessageSuffix;
    String quitMessagePrefix;
    String quitMessageSuffix;

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

    public String getQuitMessagePrefix() {
        return quitMessagePrefix;
    }

    public void setQuitMessagePrefix(String quitMessagePrefix) {
        this.quitMessagePrefix = quitMessagePrefix;
    }

    public String getQuitMessageSuffix() {
        return quitMessageSuffix;
    }

    public void setQuitMessageSuffix(String quitMessageSuffix) {
        this.quitMessageSuffix = quitMessageSuffix;
    }
}
