package ca.umontreal.iro.hurtubin.fragmentsexample;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Dans le cas où la vue ne permet qu'un seul fragment à la fois
        if(findViewById(R.id.fragment_container) != null && savedInstanceState == null) {

            final HelloFragment helloFragment = new HelloFragment();
            final TodoFragment todoFragment = new TodoFragment();

            // Fragment par défaut
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, helloFragment)
                    .commit();

            // Boutons pour remplacer le fragment actif
            Button helloButton = (Button) findViewById(R.id.hello_btn);
            Button todoButton = (Button) findViewById(R.id.todo_btn);

            helloButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, helloFragment)
                            .addToBackStack(null) // Permet de revenir au dernier fragment avec le bouton Back
                            .commit();
                }
            });

            todoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, todoFragment)
                            .addToBackStack(null)
                            .commit();
                }
            });
        }
    }
}
