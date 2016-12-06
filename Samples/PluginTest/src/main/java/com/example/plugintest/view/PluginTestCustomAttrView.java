package com.example.plugintest.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.plugintest.R;

/**
 * 测试插件程序找中是否可以使用自定义控件自定义属性
 * @author cailiming
 *
 */
public class PluginTestCustomAttrView extends LinearLayout {

	private String attrText;
	private int attrColor;
	private float attrSize;

	public PluginTestCustomAttrView(Context context) {
		super(context);
	}

	public PluginTestCustomAttrView(Context context, AttributeSet attrs) {
		super(context, attrs);

		final TypedArray a = context.obtainStyledAttributes(
				attrs, R.styleable.PluginTestCustomAttrView, 0, 0);

		attrText = a.getString(R.styleable.PluginTestCustomAttrView_custarr_text);
		attrColor = a.getColor(R.styleable.PluginTestCustomAttrView_custarr_text_color, 0);
		attrSize = a.getDimension(R.styleable.PluginTestCustomAttrView_custarr_text_color_size, 0);

		a.recycle();
	}

	private int indexof(int attr, int[] attrArray) {
		for (int i=0; i< attrArray.length; i++) {
			if (attr == attrArray[i]) {
				return i;
			}
		}
		return -1;
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		LayoutInflater.from(getContext()).inflate(R.layout.plugin_test_view, this);
		Button button = (Button)findViewById(R.id.btnPlugin);
		button.setText(button.getText().toString() + attrText);
		button.setTextColor(attrColor);
		button.setTextSize(attrSize);
	}
}
