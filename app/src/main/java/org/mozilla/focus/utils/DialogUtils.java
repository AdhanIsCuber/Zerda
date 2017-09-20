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
