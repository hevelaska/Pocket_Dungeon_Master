package be.hevelaska.pdm.model.monster;

import android.os.Parcel;
import android.os.Parcelable;

public class Monster implements Parcelable {
    private String name;
    private String description;
    private int level;
    private String motive;
    private EncounterType encounterType;
    private String environment;
    private int health;
    private int damages;
    private int armor;
    private MovementType movementType;
    private String modifications;
    private String combat;
    private String interaction;
    private String use;
    private String loot;
    private String image;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLevel() {
        return level;
    }

    public String getMotive() {
        return motive;
    }

    public EncounterType getEncounterType() {
        return encounterType;
    }

    public String getEnvironment() {
        return environment;
    }

    public int getHealth() {
        return health;
    }

    public int getDamages() {
        return damages;
    }

    public int getArmor() {
        return armor;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public String getModifications() {
        return modifications;
    }

    public String getCombat() {
        return combat;
    }

    public String getInteraction() {
        return interaction;
    }

    public String getUse() {
        return use;
    }

    public String getLoot() {
        return loot;
    }

    public String getImage() {
        return image;
    }

    protected Monster(Parcel in) {
        name = in.readString();
        description = in.readString();
        level = in.readInt();
        motive = in.readString();
        String ET = in.readString();
        encounterType = ET == null ? null : EncounterType.valueOf(ET);
        environment = in.readString();
        health = in.readInt();
        damages = in.readInt();
        armor = in.readInt();
        String mov = in.readString();
        movementType = mov == null ? null : MovementType.valueOf(mov);
        modifications = in.readString();
        combat = in.readString();
        interaction = in.readString();
        use = in.readString();
        loot = in.readString();
        image = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(level);
        dest.writeString(motive);
        dest.writeString(encounterType == null ? null : encounterType.name());
        dest.writeString(environment);
        dest.writeInt(health);
        dest.writeInt(damages);
        dest.writeInt(armor);
        dest.writeString(movementType == null ? null : movementType.name());
        dest.writeString(modifications);
        dest.writeString(combat);
        dest.writeString(interaction);
        dest.writeString(use);
        dest.writeString(loot);
        dest.writeString(image);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Monster> CREATOR = new Parcelable.Creator<Monster>() {
        @Override
        public Monster createFromParcel(Parcel in) {
            return new Monster(in);
        }

        @Override
        public Monster[] newArray(int size) {
            return new Monster[size];
        }
    };
}