package br.ucam_campos.alarme;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    @SuppressWarnings("unused")
      private static final String TAG = Adapter.class.getSimpleName();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView subtitle;

        public ViewHolder(View itemView) {
            super(itemView);


            title = (TextView) itemView.findViewById(R.id.title);
            subtitle = (TextView) itemView.findViewById(R.id.subtitle);
        }
    }

    protected MainActivity context;


    private static final int ITEM_COUNT = 21;

    private List<Item> items;

    public Adapter(Context c) {
        super();




        SharedPreferences prefs = c.getSharedPreferences("PREFERENCIAS", Context.MODE_PRIVATE);

        // criando itens da tabela
        items = new ArrayList<>();
        for (int i = 0; i <= prefs.getInt("total", 0); i++) {
            if (prefs.contains("hora_" + i)) {
                MainActivity.textViewObj.setVisibility(View.INVISIBLE);
                items.add(new Item("Hora: "+prefs.getString("hora_" + i, ""), "Modo: " + prefs.getString("modo_" + i, "")));
                System.out.println("Loop: " + i);
            } else {
                MainActivity.textViewObj.setVisibility(View.VISIBLE);
                System.out.println("Nao contem: " + i);
            }
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Item item = items.get(position);

        holder.title.setText(item.getHora());
        holder.subtitle.setText(item.getModo());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
