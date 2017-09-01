package org.mozilla.focus.utils;


import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.mozilla.focus.R;

public class DialogUtils {

    public static AlertDialog showScreenshotOnBoardingDialog(Context context) {
        final AlertDialog dialog = new AlertDialog.Builder(context).create();
        View dialogView = LayoutInflater.from(context).inflate(R.layout.layout_screenshot_onboarding_dialog, null);


        TextView textView = (TextView) dialogView.findViewById(R.id.dialog_screenshot_on_boarding_text);
        ImageSpan imageSpan = new ImageSpan(context, R.drawable.action_capture);
        String emptyPrefix = context.getString(R.string.screenshot_on_boarding_text_msg_prefix);
        String emptyPostfix = context.getString(R.string.screenshot_on_boarding_text_msg_postfix);
        SpannableString spannableString = new SpannableString(emptyPrefix + emptyPostfix);

        int start = emptyPrefix.length();
        int end = start + 1;
        spannableString.setSpan(imageSpan, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        textView.setText(spannableString);

        dialogView.findViewById(R.id.dialog_screenshot_on_boarding_btn_got_it).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dialog != null)
                    dialog.dismiss();
            }
        });
        dialog.setView(dialogView);
        dialog.show();
        Settings.getInstance(context).setScreenshotOnBoardingDone();
        return dialog;
    }

}
