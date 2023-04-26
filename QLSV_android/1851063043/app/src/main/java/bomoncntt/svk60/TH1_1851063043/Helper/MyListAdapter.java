package bomoncntt.svk60.TH1_1851063043.Helper;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import bomoncntt.svk60.TH1_1851063043.R;
import bomoncntt.svk60.TH1_1851063043.Model.SinhVien;


public class MyListAdapter extends ArrayAdapter<SinhVien> {

    private final Activity context;
    private final ArrayList<SinhVien> listsv;

    private static class ViewHolder {

        TextView txtMasv;
        TextView txtTensv;
        TextView txtgt;
        TextView txtlop;
        CircleImageView croppedImageView;
    }

    public MyListAdapter(Activity context, ArrayList<SinhVien> data) {
        super(context, R.layout.layout_item_sv, data);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.listsv = data;
        Log.d("listsv",""+listsv);

    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        SinhVien dataModel = getItem(position);
        ViewHolder viewHolder;
        final View result;
        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());


            convertView = inflater.inflate(R.layout.layout_item_sv, parent, false);


            viewHolder.txtMasv =  convertView.findViewById(R.id.item_txtmasv);
            viewHolder.txtTensv =  convertView.findViewById(R.id.item_txttensv);
            viewHolder.txtgt=convertView.findViewById(R.id.item_txtgt);
            viewHolder.txtlop=convertView.findViewById(R.id.item_txtlop);
            viewHolder.croppedImageView=convertView.findViewById(R.id.imageViewsv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtMasv.setText(dataModel.getMasv());
        viewHolder.txtTensv.setText(dataModel.getTensv());
        viewHolder.txtgt.setText(dataModel.getGt());
        viewHolder.txtlop.setText(dataModel.getLop());
        String anhsv=dataModel.getAnhsv();
        Log.v("anhsvcus",anhsv);

        viewHolder.croppedImageView.setImageBitmap(Common.StringToBitMap(anhsv));
        return convertView;

    };
}