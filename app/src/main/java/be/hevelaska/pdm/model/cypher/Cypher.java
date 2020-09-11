package be.hevelaska.pdm.model.cypher;

import android.os.Parcel;
import android.os.Parcelable;

public class Cypher implements Parcelable{
    private String name;
    private CypherType type;
    private String level;
    private String utilisable;
    private String effet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CypherType getType() {
        return type;
    }

    public void setType(CypherType type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUtilisable() {
        return utilisable;
    }

    public void setUtilisable(String utilisable) {
        this.utilisable = utilisable;
    }

    public String getEffet() {
        return effet;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    protected Cypher(Parcel in) {
        name = in.readString();
        utilisable = in.readString();
        level = in.readString();
        effet = in.readString();
        String CT = in.readString();
        type = CT == null ? null : CypherType.valueOf(CT);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(utilisable);
        dest.writeString(level);
        dest.writeString(effet);
        dest.writeString(type == null ? null : type.name());
    }

    public static final Parcelable.Creator<Cypher> CREATOR = new Parcelable.Creator<Cypher>() {
        @Override
        public Cypher createFromParcel(Parcel in) { return new Cypher(in);}

        @Override
        public Cypher[] newArray(int size) { return new Cypher[size];}
    };
}
