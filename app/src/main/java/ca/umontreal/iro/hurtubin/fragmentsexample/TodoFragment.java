package ca.umontreal.iro.hurtubin.fragmentsexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class TodoFragment extends Fragment {

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.todo_view, container, false);

        list = (ListView) view.findViewById(R.id.list);

        String[] items = new String[]{"Faire un Hello World", "Faire une App Android", "Faire la vaisselle"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, items);

        list.setAdapter(adapter);

        return view;
    }
}
