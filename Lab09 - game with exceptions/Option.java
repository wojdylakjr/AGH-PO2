public enum Option {
    RESET('r', "Reset gry", null),
    LEFT('a', "Skret w lewo", Direction.LEFT),
    RIGHT('d', "Skret w prawo", Direction.RIGHT),
    UP('w', "Do gory", Direction.UP),
    DOWN('s', "W dol", Direction.DOWN),
    EXIT('e', "Wyjscie z gry", null);

    private final char sign;
    private final String info;
    private final Direction direction;

    Option(char sign, String info, Direction direction) {
        this.sign = sign;
        this.info = info;
        this.direction = direction;
    }

    public final char getSign() {
        return this.sign;
    }

    public String getInfo() {
        return this.info;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "'" + sign + "' ==> opcja " + this.name() + ", opis: " + this.info
                + ", wektor presuniecia: " + direction;
    }
}