package com.project.appprimerparcial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Toast;

public class DialogNitificationActivity extends AppCompatActivity {

    private Context context;
    private Toast myToast;
    private AlertDialog.Builder dialogConf;
    private AlertDialog myDialog;

    private NotificationCompat.Builder myBuilder;
    private NotificationManager myNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_nitification);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        context = getApplicationContext();
    }

    private void mostrarDialog(){
        dialogConf = new AlertDialog.Builder(this);
        dialogConf.setTitle("Curso de programación");
        dialogConf.setMessage("Tienes el curso completamente gratis\n¿Quieres suscribirte?");

        dialogConf.setPositiveButton("Si",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        notificar("Suscripción completada");
                        Intent intent = new Intent(getApplicationContext(), ChildActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
        dialogConf.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        notificar("No te pierdas esta oportunidad");
                    }
                });

        dialogConf.setNeutralButton("Más tarde",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        notificar("Te lo recordaré luego C:");
                    }
                });

        myDialog = dialogConf.create();
        myDialog.show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        mostrarDialog();
    }

    private void notificar(String message){
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.user);

        NotificationChannel myChannel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            myChannel = new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);


            Intent intent = new Intent(getApplicationContext(), ChildActivity.class);
            PendingIntent myPendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            myBuilder = new NotificationCompat.Builder(getApplicationContext(), "CHANNEL_ID")
                    .setSmallIcon(R.mipmap.ic_launcher_round) // notification icon
                    .setContentTitle("Curso de programación")
                    .setContentText(message)
                    .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bm))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(myPendingIntent)
                    .addAction(0, "Ver", myPendingIntent)
                    .setAutoCancel(false);

            // Finally, we create the actual Notification method and assign it the channel
            myNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            myNotificationManager.createNotificationChannel(myChannel);

            myNotificationManager.notify(0, myBuilder.build());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return true;
    }
}