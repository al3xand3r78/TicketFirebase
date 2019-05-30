package alessandro.mystudio.ticketfirebase.RecyclerView;

public class Ticket {

    public int ticket;
    public String redattore;
    public String targa;
    public int dataApertura;
    public String materialeGuasto;
    public int dataChiusura;

    public Ticket(int ticket, String redattore, String targa , int dataApertura, String materialeGuasto, int dataChiusura) {

        this.ticket = ticket;
        this.redattore = redattore;
        this.targa = targa;
        this.dataApertura = dataApertura;
        this.materialeGuasto = materialeGuasto;
        this.dataChiusura = dataChiusura;

    }

    public int getTicket() {
        return ticket;
    }

    public String getRedattore() {
        return redattore;
    }

    public String getTarga() {
        return targa;
    }

    public int getDataApertura() {
        return dataApertura;
    }

    public String getMaterialeGuasto() {
        return materialeGuasto;
    }

    public int getDataChiusura() {
        return dataChiusura;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public void setRedattore(String redattore) {
        this.redattore = redattore;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public void setDataApertura(int dataApertura) {
        this.dataApertura = dataApertura;
    }

    public void setMaterialeGuasto(String materialeGuasto) {
        this.materialeGuasto = materialeGuasto;
    }

    public void setDataChiusura(int dataChiusura) {
        this.dataChiusura = dataChiusura;
    }

}
