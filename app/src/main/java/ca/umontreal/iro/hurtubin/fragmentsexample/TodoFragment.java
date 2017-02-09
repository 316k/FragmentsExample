package ca.umontreal.iro.hurtubin.fragmentsexample;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TodoFragment extends ListFragment {

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        String[] items = new String[]{
                "Faire un Hello World",
                "Faire une App Android",
                "Faire la vaisselle",
                "Faire un ListFragment",
                "Faire une TodoList dans mon ListFragment",
                "Ajouter des items dans la TodoList",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, items);

        this.setListAdapter(adapter);

        return view;
    }
}
