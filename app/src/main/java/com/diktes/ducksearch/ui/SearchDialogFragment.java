package com.diktes.ducksearch.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.diktes.ducksearch.R;
import com.diktes.ducksearch.datamodel.DataModel;

public class SearchDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.search_layout, null);

        final AutoCompleteTextView autoCompleteTextView =  (AutoCompleteTextView) view.findViewById(R.id.search_value);
        autoCompleteTextView.setText(DataModel.getInstance().getLastSearch());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line, DataModel.getInstance().getRecentSearchArray());
        autoCompleteTextView.setAdapter(adapter);

        builder.setView(view)
                .setPositiveButton(R.string.button_search, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        DataModel.getInstance().addSearch(autoCompleteTextView.getText().toString());
                    }
                });
        return builder.create();
    }


}
