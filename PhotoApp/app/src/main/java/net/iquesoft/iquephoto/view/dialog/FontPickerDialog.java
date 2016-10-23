package net.iquesoft.iquephoto.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import net.iquesoft.iquephoto.R;
import net.iquesoft.iquephoto.adapters.FontsAdapter;
import net.iquesoft.iquephoto.model.Font;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FontPickerDialog extends Dialog {

    private int mColor;
    private String mText;
    private Context mContext;

    private Typeface typeface;

    @BindView(R.id.fontsList)
    RecyclerView fontsList;

    private boolean bold;
    private boolean italic;

    public FontPickerDialog(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.dialog_font_picker);

        ButterKnife.bind(this);

        initFontsList();
    }

    @OnClick(R.id.applyTextStyle)
    void onClickApplyTextStyle() {
        //textFragment.setTypeface(typeface);
        dismiss();
    }

    @OnClick(R.id.cancelTextStyle)
    void onClickCancel() {
        dismiss();
    }

    public void initFontsList() {
        FontsAdapter fontsAdapter = new FontsAdapter(Font.getFontsList());
        fontsList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        fontsAdapter.setFontsListener(font -> {
            typeface = Typeface.createFromAsset(getContext().getAssets(), font.getTypeface());
        });
        fontsList.setAdapter(fontsAdapter);

    }

    public void showDialog(String text, int color) {
        mText = text;
        mColor = color;
        show();
    }

    public Typeface getTypeface() {
        return typeface;
    }

    public int getColor() {
        return 0;
    }

    public boolean isItalic() {
        return italic;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public void setColor(int color) {
        mColor = color;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}