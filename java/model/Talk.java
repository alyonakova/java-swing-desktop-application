package model;

public class Talk {
    private TalkTheme theme;

    public Talk(TalkTheme theme) {
        this.theme = theme;
        System.out.println(this);
    }

    public Talk() {
        this.theme = TalkTheme.sample();
        System.out.println(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Talk)
            return this.theme.equals(((Talk) obj).theme);
        else
            return false;
    }

    @Override
    public int hashCode() {
        return this.theme.hashCode();
    }

    @Override
    public String toString() {
        switch (this.theme) {
            case FOOD:
                return "Conversation about food\n" + TalkTheme.FOOD.getMessage();
            case BOOKS:
                return "Conversation about books\n" + TalkTheme.BOOKS.getMessage();
            case FILMS:
                return "Conversation about films\n" + TalkTheme.FILMS.getMessage();
            case WEATHER:
                return "Conversation about weather\n" + TalkTheme.WEATHER.getMessage();
            default:
                return "Conversation about nothing";
        }
    }
}
