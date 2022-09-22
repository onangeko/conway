package model;

public enum EntityCode {
Alive('O'),
Dead('X');

    private final char code;

    EntityCode(char code) {
        this.code = code;
    }

    private char getCode() {
        return code;
    }

    public static EntityCode fromCode(char c) throws Exception {
        for (EntityCode entity : values()) {
            if (entity.getCode() == c)
                return entity;
        }
        throw new Exception("Invalid character " + c);
    }

    public static char fromBoolean(boolean b) {
        if (b) {
            return Alive.code;
        } else {
            return Dead.code;
        }
    }

    public static boolean processEntityCode(EntityCode entityCode) throws Exception {
        if (entityCode == EntityCode.Alive) {
            return true;
        } else if (entityCode == EntityCode.Dead) {
            return false;
        } else {
            throw new Exception("Invalid character ");
        }
    }



}
