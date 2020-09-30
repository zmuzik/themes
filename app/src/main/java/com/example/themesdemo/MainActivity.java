package com.example.themesdemo;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static final int BLUE_THEME = R.style.AppTheme;
    static final int GREEN_THEME = R.style.GreenTheme;

    // persist this value e.g. in SharedPreferences
    static int currentTheme = BLUE_THEME;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(currentTheme);
        setContentView(R.layout.activity_main);

        final TextView helloWorldLabel = findViewById(R.id.helloWorldLabel);
        int customColor = getColorByAttributeId(this, R.attr.custom_color);
        helloWorldLabel.setTextColor(customColor);
        helloWorldLabel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                currentTheme = (currentTheme == BLUE_THEME) ? GREEN_THEME : BLUE_THEME;
                setTheme(currentTheme);
                recreate();
            }
        });
    }

    @ColorInt
    public int getColorByAttributeId(Context context, @AttrRes int attrIdForColor){
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(attrIdForColor, typedValue, true);
        return typedValue.data;
    }
}
