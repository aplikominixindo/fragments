package id.inixindosurabaya.androidfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailPizzaFragment extends Fragment {
    // komponen dalam layout
    TextView txtTitle, txtDetail;
    int position = 0;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null){
            if (getArguments() != null) {
                position = getArguments()
                        .getInt("posisi", 0);
            }
        }
    }

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_detail_pizza,
                container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        // inisialisasi komponen dalam layout
        txtTitle = (TextView)view.findViewById(R.id.textViewTitle);
        txtDetail = (TextView)view.findViewById(R.id.textViewDetail);

        // isi text view dengan nilai title dan detail
        txtTitle.setText(Pizza.pizzaMenu[position]);
        txtDetail.setText(Pizza.pizzaDetail[position]);
    }

    // method untuk mengubah nilai title dan detail
    // jika pilihan menu berubah
    public void updateDetail(int position){
        txtTitle.setText(Pizza.pizzaMenu[position]);
        txtDetail.setText(Pizza.pizzaDetail[position]);
    }
}
