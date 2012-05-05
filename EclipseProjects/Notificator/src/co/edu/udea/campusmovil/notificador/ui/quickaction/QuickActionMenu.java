package co.edu.udea.campusmovil.notificador.ui.quickaction;

import co.edu.udea.campusmovil.notificador.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.Toast;

public class QuickActionMenu extends MyPopUpWindow implements OnClickListener {

    public QuickActionMenu(View anchor) {
        super(anchor);
    }

    @Override
    protected void onCreate() {
        LayoutInflater layout = (LayoutInflater) this.anchor.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup root = (ViewGroup) layout.inflate(R.layout.popup_layout, null);

        for (int i = 0, icount = root.getChildCount(); i < icount; i++) {
            View view = root.getChildAt(i);

            if (view instanceof TableRow) {
                TableRow tableRow = (TableRow) view;

                for (int j = 0, jcount = tableRow.getChildCount(); j < jcount; j++) {
                    View item = tableRow.getChildAt(j);

                    if (item instanceof ImageButton) {
                        ImageButton button = (ImageButton) item;
                        button.setOnClickListener(this);
                    }
                }
            }
        }

        this.setContentView(root);
    }

    public void onClick(View view) {
        Toast.makeText(this.anchor.getContext(), "Yes... It Works!!!", Toast.LENGTH_SHORT).show();

        if (view.getId() == R.id.oneButton) {
            Toast.makeText(this.anchor.getContext(), "One Button Clicked!!", Toast.LENGTH_SHORT).show();
        }
        //this.anchor
        
        this.dismiss();
    }
}
