package co.edu.udea.campusmovil.notificador.ui.quickaction;

import co.edu.udea.campusmovil.notificador.R;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MyPopUpWindow {

    protected final View anchor;
    private Drawable background = null;
    private final PopupWindow popUp;
    private View root;
    private final WindowManager wManager;

    public MyPopUpWindow(View anchor) {
        this.anchor = anchor;
        this.popUp = new PopupWindow(this.anchor.getContext());

        this.popUp.setTouchInterceptor(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    MyPopUpWindow.this.popUp.dismiss();

                    return true;
                }

                return false;
            }
        });

        this.wManager = (WindowManager) this.anchor.getContext().getSystemService(Context.WINDOW_SERVICE);
        onCreate();
    }

    protected void onCreate() {
    }

    protected void onShow() {
    }

    private void preShow() {
        if (this.root == null) {
            throw new IllegalStateException("The method \"setContentView\" was not called with a view to display.");
        }
        this.onShow();

        if (this.background == null) {
            this.popUp.setBackgroundDrawable(new BitmapDrawable());
        } else {
            this.popUp.setBackgroundDrawable(this.background);
        }

        this.popUp.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        this.popUp.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        this.popUp.setTouchable(true);
        this.popUp.setFocusable(true);
        this.popUp.setOutsideTouchable(true);

        this.popUp.setContentView(this.root);
    }

    public void setBackgroundDrawable(Drawable background) {
        this.background = background;
    }

    public void setContentView(View root) {
        this.root = root;
        this.popUp.setContentView(this.root);
    }

    public void setContentView(int layoutResId) {
        LayoutInflater layout = (LayoutInflater) this.anchor.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.setContentView(layout.inflate(layoutResId, null));
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener l) {
        this.popUp.setOnDismissListener(l);
    }

    public void showQuickAction() {
        this.showQuickAction(0, 0);
    }

    public void showQuickAction(int xOffSet, int yOffSet) {
        this.preShow();
        this.popUp.setAnimationStyle(R.style.Animations_GrowFromBottom);

        int[] location = new int[2];
        this.anchor.getLocationOnScreen(location);

        Rect anchorRect = new Rect(location[0], location[1], location[0] + this.anchor.getWidth(), location[1] + this.anchor.getHeight());

        this.root.measure(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        int rootWidth = this.root.getMeasuredWidth();
        int rootHeight = this.root.getMeasuredHeight();

        int screenWidth = this.wManager.getDefaultDisplay().getWidth();
        int screenHeight = this.wManager.getDefaultDisplay().getHeight();

        int xPos = screenWidth - rootWidth + xOffSet;
        int yPos = location[1] + (this.anchor.getHeight() / 2) + yOffSet;

        if (rootHeight > anchorRect.top) {
            yPos = anchorRect.bottom + yOffSet;
            this.popUp.setAnimationStyle(R.style.Animations_GrowFromTop);
        }

        this.popUp.showAtLocation(this.anchor, Gravity.NO_GRAVITY, xPos, yPos);
    }

    public void dismiss() {
        this.popUp.dismiss();
    }
}
