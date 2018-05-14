package com.robert.mccormickrob_ce03;


// Robert Mccormick
// MDV3325-O 01
// MccormickRob_CE03


import android.content.res.Configuration;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FrameLayout fr_first;
    TextView tv_top_text;
    RadioGroup rg_back_color, rg_text_color;
    RadioButton r_purple, r_green, r_black, r_t_purple, r_t_green, r_t_black;
    EditText ed_display_text;
    Switch sw_bold_text;
    ImageView iv_image;
    String text="Text Appears Here";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fr_first = (FrameLayout) findViewById(R.id.frame_first);
        tv_top_text = (TextView) findViewById(R.id.tv_text_color);
        iv_image=(ImageView)findViewById(R.id.iv_image);
        rg_back_color = (RadioGroup) findViewById(R.id.radio_group_color);
        rg_text_color = (RadioGroup) findViewById(R.id.radio_group_text_color);
        r_purple = (RadioButton) findViewById(R.id.rb_purple);
        r_green = (RadioButton) findViewById(R.id.rb_green);
        r_black = (RadioButton) findViewById(R.id.rb_black);
        r_t_black = (RadioButton) findViewById(R.id.rb_txt_black);
        r_t_purple = (RadioButton) findViewById(R.id.rb_txt_purple);
        r_t_green = (RadioButton) findViewById(R.id.rb_txt_green);
        ed_display_text = (EditText) findViewById(R.id.ed_display_text);
        sw_bold_text = (Switch) findViewById(R.id.sw_bold);


        ed_display_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
                tv_top_text.setText(s);
                text=""+s;
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

                // TODO Auto-generated method stub
            }
        });

        rg_back_color.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_purple:
                        fr_first.setBackgroundResource(R.color.purple);
                        break;
                    case R.id.rb_green:
                        fr_first.setBackgroundResource(R.color.green);
                        break;
                    case R.id.rb_black:
                        fr_first.setBackgroundResource(R.color.black);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Default", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
        rg_text_color.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_txt_purple:
                        tv_top_text.setTextColor(getResources().getColor(R.color.purple));
                        break;
                    case R.id.rb_txt_green:
                        tv_top_text.setTextColor(getResources().getColor(R.color.green));
                        break;
                    case R.id.rb_txt_black:
                        tv_top_text.setTextColor(getResources().getColor(R.color.black));
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Default text", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        sw_bold_text.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                if (isChecked == true) {
                    tv_top_text.setTypeface(null, Typeface.BOLD);
                } else {
                    tv_top_text.setTypeface(null, Typeface.NORMAL);
                }

            }
        });


    }


    @Override
    protected void onSaveInstanceState(Bundle out) {
        super.onSaveInstanceState(out);
        String a=tv_top_text.getText().toString();
        tv_top_text.setText(a);
        iv_image.setBackgroundResource(R.drawable.star);
    }

    @Override
    protected void onRestoreInstanceState(Bundle in) {
        super.onRestoreInstanceState(in);
        if(text==""){
            tv_top_text.setText("Text Appears Here");
        }

        else {
            tv_top_text.setText(text);
        }
        iv_image.setBackgroundResource(R.drawable.star);

    }

}
