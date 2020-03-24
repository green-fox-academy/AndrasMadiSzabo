package aircraftCarrier;

public class Aircraft {
    protected int maxAmmo;
    protected int baseDamage;
    protected String type;
    protected int ammunition;
    protected boolean isPriority;
    protected int allDamage;

    public Aircraft () {
        this.ammunition = 0;
    }

    public int fight () {
        int dealtDamage = baseDamage * ammunition;
        ammunition = 0;
        allDamage += dealtDamage;
        return dealtDamage;
    }

    public int refill (int number) {
        if (number > maxAmmo) {
            ammunition = maxAmmo;
        } else ammunition = number;
        return number-ammunition;
    }

    public String getType () {
        return type;
    }

    public String getStatus () {
        return "Type " + type + ", Ammo: " + ammunition + ", Base Damage: " +
                baseDamage + ", All Damage: " + allDamage;
    }

    public boolean isPriority () {
        if (type == "F16") {
            return false;
        } else {
            return true;
        }
    }
}
