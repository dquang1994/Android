package com.example.nvdq1.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SampleDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        /* General */
        /*AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.sample_dialog, null);

        Button btnOk = (Button) dialogView.findViewById(R.id.btnOk);
        Button btnCancel = (Button) dialogView.findViewById(R.id.btnCancel);

        builder.setView(dialogView).setMessage("Please make a choose");

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Button OK is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "Button Cancel is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();*/

        /* only create a simple dialog such as making a choose */
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Make a selection");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity().getApplicationContext(), "Button OK is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity().getApplicationContext(), "Button Cancel is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }
}
