package id.inixindosurabaya.androidfragments;

import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MenuPizzaFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // deteksi posisi gadget
        // portrait atau landscape
        Log.d("POSISI", getResources()
                    .getConfiguration().orientation + "");
        if (savedInstanceState == null) {
            // munculkan untuk pertama kali
            // fragment menu pizza
            MenuPizzaFragment fragment = new MenuPizzaFragment();
            FragmentTransaction transaction =
                    getSupportFragmentManager()
                    .beginTransaction();
            transaction.add(R.id.frameContainer, fragment);
            transaction.commit();
        }

        // jika orientasi adalah landscape
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            // panggil fragment detail pizza
            DetailPizzaFragment detailFragment =
                    new DetailPizzaFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("posisi", 0);

            detailFragment.setArguments(bundle);
            FragmentTransaction transaction =
                    getSupportFragmentManager()
                    .beginTransaction();
            transaction.add(R.id.frameContainer, detailFragment);
            transaction.commit();
        }
    }

    public void OnPizzaItemSelected(int position) {
        Toast.makeText(this,
                "Fragment Menu: posisi : " + position,
                Toast.LENGTH_LONG).show();

        // buka detail pizza dari menu yg dipilih
        DetailPizzaFragment detailFragment =
                new DetailPizzaFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("posisi", position);
        detailFragment.setArguments(bundle);

        // cek jika orientasi adalah landscape
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameContainer, detailFragment)
                    .commit();
        }
        // cek jika orientasi adalah portrait
        else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameContainer, detailFragment)
                    .commit();
        }
    }
}
