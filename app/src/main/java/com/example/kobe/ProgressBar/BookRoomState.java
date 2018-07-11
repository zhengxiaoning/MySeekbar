package com.example.kobe.ProgressBar;

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2018/7/11.
 */
public class BookRoomState {
    private String state;
    private int icon;
    public BookRoomState(){}
    public BookRoomState(String state,int icon){
        this.state=state;
        this.icon=icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIcon() {
        return icon;
    }

    public String getState() {
        return state;
    }
}
