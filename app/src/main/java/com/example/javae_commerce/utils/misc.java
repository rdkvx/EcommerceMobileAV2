package com.example.javae_commerce.utils;

import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;


public class misc {

     public static void msgAlert(android.content.Context ctx, String msg, String titulo){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(ctx);
        builder1.setMessage(msg);
        builder1.setCancelable(true);
        builder1.setTitle(titulo);

        builder1.setPositiveButton(
                constants.ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).create();

        builder1.show();
    }
}
