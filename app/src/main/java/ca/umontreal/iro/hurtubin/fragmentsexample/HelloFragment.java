package ca.umontreal.iro.hurtubin.fragmentsexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

public class HelloFragment extends Fragment {

    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.hello_view, container, false);

        button = (Button) view.findViewById(R.id.button);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Hello World !", Toast.LENGTH_SHORT).show();
            }
        });
        
        return view;
    }
}
