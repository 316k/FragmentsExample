package ca.umontreal.iro.hurtubin.fragmentsexample;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HelloFragment extends Fragment {

    Button button;
    Button preferencesBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.hello_view, container, false);

        button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = v.getContext();

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c);

                String username = preferences.getString("username", "Utilisateur anonyme");

                int affichages = preferences.getInt("affichages", 0);

                Toast.makeText(v.getContext(), "Bonjour, " + username + " ! Vous avez affiché " + affichages + " Toasts depuis l'installation !", Toast.LENGTH_SHORT).show();

                affichages++;

                preferences
                        .edit()
                        .putInt("affichages", affichages)
                        .commit();
            }
        });

        preferencesBtn = (Button) view.findViewById(R.id.preferences_btn);
        preferencesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
