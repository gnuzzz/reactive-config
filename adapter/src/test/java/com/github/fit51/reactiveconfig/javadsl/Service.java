package com.github.fit51.reactiveconfig.javadsl;

/**
 * @author Vladimir Kornyshev {@literal <vkornyshev@at-consulting.ru>}
 */
public class Service {

    private String value;

    public Service(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void doStart() {
        //do nothing
    }
    public void doStop() {
        //do nothing
    }
}
