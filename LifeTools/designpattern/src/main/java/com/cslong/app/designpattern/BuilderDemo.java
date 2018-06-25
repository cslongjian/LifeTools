package com.cslong.app.designpattern;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by chenlongjian on 2018/6/25.
 */

public class BuilderDemo extends android.support.v4.app.DialogFragment {
    String title;
    String message;
    String negativeText;
    View.OnClickListener clickNegativeListener;
    OnClickListener clickNegativeWithFragmentReturn;
    String positiveText;
    View.OnClickListener clickPositiveListener;
    OnClickListener clickPositiveWithFragmentReturn;
    String singleButtonText;
    View.OnClickListener clickSingleButtonListener;
    OnClickListener clickSingleWithFragmentReturn;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View dialogView = initDialogView();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setView(dialogView);
        return builder.create();
    }

    private View initDialogView() {
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.common_dialog_layout, null);
        if(TextUtils.isEmpty(title)){
            dialogView.findViewById(R.id.title_view).setVisibility(View.GONE);
        }else{
            ((TextView) dialogView.findViewById(R.id.title_view)).setText(title);
        }
        if(TextUtils.isEmpty(message)){
            dialogView.findViewById(R.id.message_view).setVisibility(View.GONE);
        }else{
            ((TextView) dialogView.findViewById(R.id.message_view)).setText(message);
        }
        TextView negativeButton = (TextView) dialogView.findViewById(R.id.negative_button);
        TextView positiveButton = (TextView)dialogView.findViewById(R.id.positive_button);
        View buttonDivider = dialogView.findViewById(R.id.divider_view);
        TextView singleButton = (TextView)dialogView.findViewById(R.id.single_button);

        if (TextUtils.isEmpty(singleButtonText)) {
            negativeButton.setText(negativeText);
            positiveButton.setText(positiveText);
            if (clickNegativeListener == null) {
                negativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clickNegativeWithFragmentReturn != null) {
                            clickNegativeWithFragmentReturn.onClick(BuilderDemo.this, v);
                        }
                    }
                });
            } else {
                negativeButton.setOnClickListener(clickNegativeListener);
            }
            if (clickPositiveListener == null) {
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clickPositiveWithFragmentReturn != null) {
                            clickPositiveWithFragmentReturn.onClick(BuilderDemo.this, v);
                        }
                    }
                });
            } else {
                positiveButton.setOnClickListener(clickPositiveListener);
            }
        } else {
            negativeButton.setVisibility(View.GONE);
            positiveButton.setVisibility(View.GONE);
            buttonDivider.setVisibility(View.GONE);
            singleButton.setVisibility(View.VISIBLE);
            singleButton.setText(singleButtonText);
            if (clickSingleButtonListener == null) {
                singleButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clickSingleWithFragmentReturn != null) {
                            clickSingleWithFragmentReturn.onClick(BuilderDemo.this, v);
                        }
                    }
                });
            } else {
                singleButton.setOnClickListener(clickSingleButtonListener);
            }
        }
        return dialogView;
    }

    public static final class Builder {
        FragmentManager manager;
        String tag;
        String title;
        String message;
        String negativeText;
        View.OnClickListener clickNegativeListener;
        OnClickListener clickNegativeWithFragmentReturn;
        String positiveText;
        View.OnClickListener clickPositiveListener;
        OnClickListener clickPositiveWithFragmentReturn;
        String singleButtonText;
        View.OnClickListener clickSingleButtonListener;
        OnClickListener clickSingleWithFragmentReturn;
        boolean cancelable;

        public Builder(FragmentManager manager) {
            this.manager = manager;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setNegativeButton(String text, View.OnClickListener listener) {
            negativeText = text;
            clickNegativeListener = listener;
            return this;
        }

        public Builder setNegativeButton(String text, OnClickListener listener) {
            negativeText = text;
            clickNegativeWithFragmentReturn = listener;
            return this;
        }

        public Builder setPositiveButton(String text, View.OnClickListener listener) {
            positiveText = text;
            clickPositiveListener = listener;
            return this;
        }

        public Builder setPositiveButton(String text, OnClickListener listener) {
            positiveText = text;
            clickPositiveWithFragmentReturn = listener;
            return this;
        }

        public Builder setSingleButton(String text, View.OnClickListener listener) {
            singleButtonText = text;
            clickSingleButtonListener = listener;
            return this;
        }

        public Builder setSingleButton(String text, OnClickListener listener) {
            singleButtonText = text;
            clickSingleWithFragmentReturn = listener;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public BuilderDemo build() {
            BuilderDemo BuilderDemo = new BuilderDemo();
            BuilderDemo.title = title;
            BuilderDemo.message = message;
            BuilderDemo.negativeText = negativeText;
            BuilderDemo.clickNegativeListener = clickNegativeListener;
            BuilderDemo.clickNegativeWithFragmentReturn = clickNegativeWithFragmentReturn;
            BuilderDemo.positiveText = positiveText;
            BuilderDemo.clickPositiveListener = clickPositiveListener;
            BuilderDemo.clickPositiveWithFragmentReturn = clickPositiveWithFragmentReturn;
            BuilderDemo.singleButtonText = singleButtonText;
            BuilderDemo.clickSingleButtonListener = clickSingleButtonListener;
            BuilderDemo.clickSingleWithFragmentReturn = clickSingleWithFragmentReturn;
            BuilderDemo.setCancelable(cancelable);
            return BuilderDemo;
        }

        public void show() {
            android.support.v4.app.DialogFragment dialogFragment = build();
            dialogFragment.show(manager, tag);
        }
    }

    public interface OnClickListener {
        void onClick(BuilderDemo dialogFragment, View v);
    }
}