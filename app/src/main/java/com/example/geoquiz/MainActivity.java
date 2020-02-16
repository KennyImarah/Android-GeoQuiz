package com.example.geoquiz;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_australia, true),
            new Question(R.string.question_ocean, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
            new Question(R.string.question_canada, true),
    };

    //declear a variable for current index
    private int mCurrentIndex = 0;

    @Override
    //method to hold instance value saved
    protected void onCreate(Bundle savedInstanceState) {
        //save instance value in savedInstanceState
        super.onCreate(savedInstanceState);
        //set content view
        setContentView(R.layout.activity_main);

        //set questions text view in a field
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        //set question current value in a field
//        int question = mQuestionBank[mCurrentIndex].getTextResId();
        //set question in view
//        mQuestionTextView.setText(question);

        //set True view value in mTrueButton
        mTrueButton = (Button) findViewById(R.id.true_button);
        //set click listener on mTrueButton
        mTrueButton.setOnClickListener(new View.OnClickListener() { //onClickListener response value set set in parenthese.
            @Override
            public void onClick(View v) {

                // Make Toast to set response to this correct value
//                Toast.makeText(MainActivity.this, R.string.correct_toast,
//                        //set Toast length and call it to show
//                        Toast.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });
        //set False view value in mFalseButton
        mFalseButton = (Button) findViewById(R.id.false_button);
        //set Click Listener for mFalseButton
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Make Toast to set response to this Incorrect value
//                Toast.makeText(MainActivity.this,
////                        R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });

        //set Next view value in mNextButton
        mNextButton = (Button) findViewById(R.id.next_button);
        //set click listener response for mNextButton
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set value in mCurrentIndex at increment with modulus mQuestionBank length
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                //get the current value of the index position
//                int question = mQuestionBank[mCurrentIndex].getTextResId();
                //set question view
//                mQuestionTextView.setText(question);
                updateQuestion();
            }
        });
        updateQuestion();
    }

    //update question method
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;
        if (userPressTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();

    }
}