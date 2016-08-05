package br.ucam_campos.alarme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by ran-j on 16/03/2016.
 */
public class Alarme_Receiver extends BroadcastReceiver {
    private String modo;
    private String hora;
    private Context context;
    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private AudioManager myAudioManager;


    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        //valor extra do modo vibrar ou tocar
        modo = intent.getStringExtra("modo");


        // inicia o serviço de audio
        myAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);


        //pega o dia da semana
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);


        //verifica o dia da semana e executa a verificação do modo
        switch (day) {

            case Calendar.MONDAY:
                System.out.println("sta01:" + modo);
                verifialarme();
                break;

            case Calendar.TUESDAY:
                System.out.println("sta02:" + modo);
                verifialarme();
                break;

            case Calendar.WEDNESDAY:
                System.out.println("sta0b:" + modo);
                verifialarme();
                break;

            case Calendar.THURSDAY:
                System.out.println("sta04:" + modo);
                verifialarme();
                break;

            case Calendar.FRIDAY:
                System.out.println("sta05:" + modo);
                verifialarme();
                break;

            case Calendar.SATURDAY:
                System.out.println("sta06:" + modo);
                verifialarme();
                break;

            case Calendar.SUNDAY:
                System.out.println("sta07:" + modo);
                verifialarme();
                break;
            default:
                verifialarme();
        }
    }

    //verifica o modo do alarme
    void verifialarme() {
        SharedPreferences prefs = context.getSharedPreferences("PREFERENCIAS", Context.MODE_PRIVATE);

        try {
            // deletar itens
            for (int i = 0; i <= prefs.getInt("total", 0); i++) {
                if (modo.contains((prefs.getString("hora_" + i, "")))) {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.remove("hora_" + i);
                    editor.remove("modo_" + i);
                    editor.commit();
                }
            }

            if (modo.contains("Vibrar")) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(context, "Setando modo Vibracal", Toast.LENGTH_SHORT).show();

            } else if (modo.contains("Tocar")) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(context, "Setando modo normal", Toast.LENGTH_SHORT).show();

            } else {
                System.out.println("sta0b2:" + modo);
            }

            if (alarmManager != null) {
                alarmManager.cancel(pendingIntent);
            }
        } catch (Exception e) {
            System.out.println("Erro 2");
        }


    }
}





