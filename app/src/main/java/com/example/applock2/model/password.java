package com.example.applock2.model;

import android.content.Context;

import io.paperdb.Paper;

public class password {

    private String PASSWORD_KEY ="PASSWORD KEY";
    public String PATTERN_SET="PATTERN SET";
    public String CONFIRM_PATTERN = "draw the pattern again to confirm";
    public String INCORRECT_PATTERN="please try again";
    public String FIRST_USE="draw an unlock pattern please";
    public String SCHEMA_FAILER="you must at least connect 4 dots!";
    public Boolean isFirst=true;

    public String getPASSWORD_KEY() {
//        return PASSWORD_KEY;
        return Paper.book().read(PASSWORD_KEY);
    }


    public void setPASSWORD_KEY(String PASS) {
//        this.PASSWORD_KEY = PASSWORD_KEY;
        Paper.book().write(PASSWORD_KEY,PASS);
    }

    public Boolean getFirst() {
        return isFirst;
    }

    public void setFirst(Boolean first) {
        isFirst = first;
    }

    public password(Context context){
        Paper.init(context);
    }

    public Boolean isCorrect(String PASS){
        return PASS.equals(getPASSWORD_KEY());
    }

}
