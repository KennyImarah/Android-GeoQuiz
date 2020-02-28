package com.example.geoquiz;

//Question class
public class Question {
    //TextField variable
    private int mTextResId;
    //AnswerTrue variable
    private boolean mAnswerTrue;

    //Question constructor
    public Question(int mTextResId, boolean mAnswerTrue){
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;
    }

    //getter and setter for fields
    public int getTextResId() {
        return mTextResId;
    }

    //mTextResId value assigned to textResId
    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    //method for isAnswerTrue
    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}