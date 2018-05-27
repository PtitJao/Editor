package util;

public abstract class Controller {
    public void reload(int value) {
        if (value % 2 == 1)
            languageChanged();

        value /= 2;

        if (value % 2 == 1) {
            //style
        }
    }

    protected abstract void languageChanged();
}
