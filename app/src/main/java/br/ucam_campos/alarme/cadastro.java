package br.ucam_campos.alarme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;



public class cadastro extends AppCompatActivity {
    private List<Item> itemList;
    private String gModo = "";
    private boolean statusBtn5 = false;
    private boolean statusBtn6 = false;
    private boolean statusBtn7 = false;
    private boolean statusBtn8 = false;
    private boolean statusBtn9 = false;
    private boolean statusBtn10 = false;
    private boolean statusBtn11 = false;


    private Button btncri;
    private Button btmcan;

    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;
    private Button btn11;




    //private PendingIntent pendingIntent;
    private TimePicker tmp;
    private RadioGroup rgru;
    Vector diasem = new Vector();
    public static final String hora = "listaKey";
    public static final String modo = "listaKey";

    // ViewHolder definition omitted
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        itemList = new ArrayList<Item>();




        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Criar Alarme");

        //botao de voltar da toolbar
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //radiogroup
        rgru = (RadioGroup) findViewById(R.id.group);

        //inciando botoes de criar alarme e cancelar
        btncri = (Button) findViewById(R.id.btncri);
        btmcan = (Button) findViewById(R.id.btmcan);


        //botoes de dia da semana
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn10 = (Button) findViewById(R.id.button10);
        btn11 = (Button) findViewById(R.id.button11);

        btn5.setBackgroundColor(Color.GRAY);
        btn6.setBackgroundColor(Color.GRAY);
        btn7.setBackgroundColor(Color.GRAY);
        btn8.setBackgroundColor(Color.GRAY);
        btn9.setBackgroundColor(Color.GRAY);
        btn10.setBackgroundColor(Color.GRAY);
        btn11.setBackgroundColor(Color.GRAY);



        //iniciando timepicker
        tmp = (TimePicker) findViewById(R.id.tmp1);


        //RadioButton
        final RadioGroup group = (RadioGroup) findViewById(R.id.group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(RadioGroup group, int id) {

                String va = getString(R.string.tipo);
                if (id == R.id.Nao) {

                    Modo.trava = "Uso";
                    gModo = "Tocar";

                } else {
                    Modo.trava = "Uso";
                    gModo = "Vibrar";
                }
            }
        });


        //botoes de dias da semana de btn5 a btn11
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diasem.add("MONDAY");

                if (statusBtn5) {
                    statusBtn5 = false;
                    btn5.cancelLongPress();

                    btn5.setBackgroundColor(Color.GRAY);
                } else {
                    statusBtn5 = true;
                    btn5.setBackgroundColor(Color.RED);
                }
                System.out.println("Sta0" + statusBtn5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diasem.add("TUESDAY");
                if (statusBtn6) {
                    statusBtn6 = false;
                    btn6.cancelLongPress();

                    btn6.setBackgroundColor(Color.GRAY);
                } else {
                    statusBtn6 = true;
                    btn6.setBackgroundColor(Color.RED);
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diasem.add("WEDNESDAY");
                if (statusBtn7) {
                    statusBtn7 = false;
                    btn7.cancelLongPress();

                    btn7.setBackgroundColor(Color.GRAY);
                } else {
                    statusBtn7 = true;
                    btn7.setBackgroundColor(Color.RED);
                }

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diasem.add("THURSDAY");
                if (statusBtn8) {
                    statusBtn8 = false;
                    btn8.cancelLongPress();

                    btn8.setBackgroundColor(Color.GRAY);
                } else {
                    statusBtn8 = true;
                    btn8.setBackgroundColor(Color.RED);
                }

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diasem.add("FRIDAY");
                if (statusBtn9) {
                    statusBtn9 = false;
                    btn9.cancelLongPress();

                    btn9.setBackgroundColor(Color.GRAY);
                } else {
                    statusBtn9 = true;
                    btn9.setBackgroundColor(Color.RED);
                }

            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diasem.add("SATURDAY");
                if (statusBtn10) {
                    statusBtn10 = false;
                    btn10.cancelLongPress();

                    btn10.setBackgroundColor(Color.GRAY);
                } else {
                    statusBtn10 = true;
                    btn10.setBackgroundColor(Color.RED);
                }

            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diasem.add("SUNDAY");
                if (statusBtn11) {
                    statusBtn11 = false;
                    btn11.cancelLongPress();

                    btn11.setBackgroundColor(Color.GRAY);
                } else {
                    statusBtn11 = true;
                    btn11.setBackgroundColor(Color.RED);
                }
            }
        });

        //botao cancelar
        btmcan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //mensagem de cancelamento
                Toast.makeText(getApplicationContext(), "Operação cancelada " + diasem, Toast.LENGTH_LONG).show();


                finish();
            }
        });

        //botao criar alarme
        btncri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //trava para verificar se o usuário selecionou o modo
                if (Modo.trava == "Zerado") {

                    Toast.makeText(getApplicationContext(), "Selecione o modo", Toast.LENGTH_LONG).show();

                } else {

                   Modo.mensagem="1";

                    //pegando a hora no TimerPicker
                    final Calendar c = Calendar.getInstance();
                    int hour = tmp.getHour();
                    int minute = tmp.getMinute();

                    //setando a hora na variavel c
                    c.set(Calendar.HOUR_OF_DAY, hour);
                    c.set(Calendar.MINUTE, minute);
                    c.set(Calendar.SECOND, 0);
                    c.set(Calendar.MILLISECOND, 0);

                    //convertendo valores para strings
                    String ho = String.valueOf(hour+":"+minute);
                    String ho2 = String.valueOf(hour);
                    String mi = String.valueOf(minute);


                    //inicia o alarme service
                    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);


                    Intent intent = new Intent(cadastro.this, Alarme_Receiver.class);

                    //passando valor extra na variavel intent
                    intent.putExtra("modo", gModo + diasem + ho);


                    final int _id = (int) System.currentTimeMillis();
                    PendingIntent appIntent = PendingIntent.getBroadcast(cadastro.this, _id, intent, PendingIntent.FLAG_ONE_SHOT);

                    //programando o alarme
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), appIntent);

                    //retorna mensagem com o a hora programada
                    Toast.makeText(getApplicationContext(), "Alarme setado para as " + ho2 + " hora(s) e " + mi + " minuto(s)", Toast.LENGTH_LONG).show();


                    //iniciando o sharedpreferences
                    SharedPreferences prefs = getSharedPreferences("PREFERENCIAS", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();

                    //salvando valores
                    int total = prefs.getInt("total", 0) + 1;
                    editor.putString("hora_" + total, ho);
                    System.out.println("Salvando hora: " + ho);
                    editor.putString("modo_" + total, gModo);
                    editor.putInt("total", total);
                    editor.commit();


                    //finalizar
                    finish();

                }

            }

        });
    }

}
