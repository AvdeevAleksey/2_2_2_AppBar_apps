package ru.avdeev.android.a2_2_2_appbar_apps;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.widget.Toast;

public class Toster {
    public Toster() {
        throw new UnsupportedOperationException();
    }
    public static void showMyMessage(int massage, Context context) {
        String text = context.getString(massage);
        SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
        biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
        Toast toast = Toast.makeText(context, biggerText, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}
