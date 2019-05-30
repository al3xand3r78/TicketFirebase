package alessandro.mystudio.ticketfirebase;

import android.os.Parcel;
import android.os.Parcelable;

public class AggiugiParcelable  implements Parcelable {
     private Integer parcTicket;
     private String parcRedattore;
     private String parcTarga;
     private Integer parcDataApertura;
     private String parcMaterialeG;
     private Integer parcDataChiusura;


    protected AggiugiParcelable(Parcel in) {
        this.parcTicket = in.readInt();
        this.parcRedattore = in.readString();
        this.parcTarga = in.readString();
        this.parcDataApertura = in.readInt();
        this.parcMaterialeG = in.readString();
        this.parcDataChiusura = in.readInt();
    }


    public AggiugiParcelable(Integer parcTicket, String parcRedattore, String parcTarga, Integer parcDataApertura, String parcMaterialeG, Integer parcDataChiusura) {
        this.parcTicket = parcTicket;
        this.parcRedattore = parcRedattore;
        this.parcTarga = parcTarga;
        this.parcDataApertura = parcDataApertura;
        this.parcMaterialeG = parcMaterialeG;
        this.parcDataChiusura = parcDataChiusura;
    }



    public static final Creator<AggiugiParcelable> CREATOR = new Creator<AggiugiParcelable>() {
        @Override
        public AggiugiParcelable createFromParcel(Parcel in) {
            return new AggiugiParcelable(in);
        }

        @Override
        public AggiugiParcelable[] newArray(int size) {
            return new AggiugiParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public Integer getParcTicket() {
        return parcTicket;
    }

    public String getParcRedattore() {
        return parcRedattore;
    }

    public String getParcTarga() {
        return parcTarga;
    }

    public Integer getParcDataApertura() {
        return parcDataApertura;
    }

    public String getParcMaterialeG() {
        return parcMaterialeG;
    }

    public Integer getParcDataChiusura() {
        return parcDataChiusura;
    }

    public void setParcTicket(Integer parcTicket) {
        this.parcTicket = parcTicket;
    }

    public void setParcRedattore(String parcRedattore) {
        this.parcRedattore = parcRedattore;
    }

    public void setParcTarga(String parcTarga) {
        this.parcTarga = parcTarga;
    }

    public void setParcDataApertura(Integer parcDataApertura) {
        this.parcDataApertura = parcDataApertura;
    }

    public void setParcMaterialeG(String parcMaterialeG) {
        this.parcMaterialeG = parcMaterialeG;
    }

    public void setParcDataChiusura(Integer parcDataChiusura) {
        this.parcDataChiusura = parcDataChiusura;
    }

    public static Parcelable.Creator<AggiugiParcelable> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.parcTicket);
        dest.writeString(this.parcRedattore);
        dest.writeString(this.parcTarga);
        dest.writeInt(this.parcDataApertura);
        dest.writeString(this.parcMaterialeG);
        dest.writeInt(this.parcDataChiusura);
    }
}
