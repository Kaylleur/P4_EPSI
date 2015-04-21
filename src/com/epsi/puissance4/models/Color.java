package com.epsi.puissance4.models;

/**
 * Created by Thomas on 21/04/2015.
 */
public enum Color {
    RED("#ff1400"),
    YELLOW("#ffe033"),
    CYAN("#11fff5"),
    BLUE("#11fff5"),
    FUSCHIA("#b51aff"),
    GREEN("#38ff19")
    ;
    private String codeHex;

    Color(String codeHex) {
        this.codeHex = codeHex;
    }

    public String getCodeHex() {
        return codeHex;
    }
}
