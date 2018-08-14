package id.inixindosurabaya.androidfragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuPizzaFragment extends Fragment {

    // buat Array Adapter
    ArrayAdapter<String> itemsAdapter;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // inisialisasi komponen
        itemsAdapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                Pizza.pizzaMenu
        );
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_menu_pizza,
                container, false);
    }

    public void onViewCreated(View view,
                              Bundle savedInstanceState){
        // inisialisasi komponen dalam layout menu pizza
        ListView listViewItems = (ListView)
                view.findViewById(R.id.listViewItems);

        // gunakan array adapter untuk distribusi
        // nilai array kedalam list view
        listViewItems.setAdapter(itemsAdapter);

        // event handling ketika salah satu nilai listview
        // dipilih / diklik
        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // jika diklik maka buka detail
                // menu tersebut
                listener.OnPizzaItemSelected(position);
            }
        });
    }

    private OnItemSelectedListener listener;

    public void onAttach(Context context) {
        super.onAttach(context);
        // cek apa isi dari attach
        if (context instanceof OnItemSelectedListener){
            this.listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
            + " harus implement ke " +
                    "MenuPizzaFragment.OnItemSelectedListener");
        }
    }

    public interface OnItemSelectedListener {
        void OnPizzaItemSelected(int position);
    }
}
