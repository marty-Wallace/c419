package labs.lab6;

public class DefaultSearch implements ISearch {

    private String pattern;

    public DefaultSearch(String pattern) {
        this.pattern = pattern;
    }

    public void setPattern(String pat) {
        this.pattern = pat;
    }

    @Override
    public boolean isIn(String text) {
        return text.contains(this.pattern);
    }

    @Override
    public String toString() {
        return "DefaultSearch";
    }

}
