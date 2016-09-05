package com.example.vale.parcelableserializable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vale on 12/07/16.
 */
public class PersonaParcelable implements Parcelable {

    private String nombre;
    private String apellido;
    private int edad;



    /**
     * este objeto CREATOR erá usado en la decodificación. De Parcel a PersonaPacerlable
     */
    public static final Parcelable.Creator<PersonaParcelable> CREATOR = new Parcelable.Creator<PersonaParcelable>() {
        public PersonaParcelable createFromParcel(Parcel in) {
            return new PersonaParcelable(in);
        }

        public PersonaParcelable[] newArray(int size) {
            return new PersonaParcelable[size];
        }
    };

    public PersonaParcelable (String nombre, int edad)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.apellido = "garcia";
    }

    public PersonaParcelable (Parcel in)
    {

        this.nombre = in.readString();//si tuviera varios string, deo leer los camps en el orden en el que fueron escritos para que la corresponsendia sea total
        this.edad = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Este método será usado en la codificación. De Persona a Parcel
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.nombre);
        dest.writeInt(this.edad);

    }

    @Override
    public String toString() {
        return nombre+edad+apellido;
    }
}
