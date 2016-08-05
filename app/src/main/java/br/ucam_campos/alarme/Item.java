package br.ucam_campos.alarme;
public class Item {
    private String hora;
    private String modo;

    Item(String hora, String modo) {
        this.hora = hora;
        this.modo = modo;
    }

    public String getModo() {
        return modo;
    }

    public String getHora() {
        return hora;
    }
}