package org.playground;

// import java.lang.StringBuilder;
import java.util.Locale;
import java.util.Formatter;

/**
 * IDE: Netbeans-27
 *   code itself was indented
 * 
 * java --version
 * openjdk 21.0.2 2024-01-16
 * OpenJDK Runtime Environment (build 21.0.2+13-58)
 * OpenJDK 64-Bit Server VM (build 21.0.2+13-58, mixed mode, sharing)
 *
 * javac -d . StringBuilderFormatterExample.java
 * java org/playground/StringBuilderFormatterExample
 * 
 * executed in Windows 11, git bash
 * 
 * Was:
 * Playing JavaFX-21.0.9
 *   with javafx.scene.layout.GridPane , javafx.scene.control.Label
 * Comparing concatenate methods in java, '+' sign and StringBuilder,
 *   people from the community seems recommended using StringBuilder
 * Finding out how to clear the text in StringBuilder
 *   by delete() and setLength() method
 * Finding out packages from java.lang.* all implicitly imported by javac,
 *   the answer is Yes
 *
 * @author Kid
 */
public class StringBuilderFormatterExample {

    private static final int BOUNDARY = 2;

    public static void main(String[] args) {
        var strBuilder = new StringBuilder();
        var formatter = new Formatter(strBuilder, Locale.US);

        for (int row = 0; row < BOUNDARY; row++) {
            for (int column = 0; column < BOUNDARY; column++) {
                //*
                strBuilder.delete(0, strBuilder.length());
                /*/
                strBuilder.setLength(0);
                //*/
                
                //*
                strBuilder.append("(y, x) = (");
                strBuilder.append(Integer.toString(row));
                strBuilder.append(", ");
                strBuilder.append(Integer.toString(column));
                strBuilder.append(")");
                System.out.println(strBuilder.toString());
                /*/
                formatter.format("(y, x) = (%d, %d)", row, column);
                System.out.println(formatter.toString());
                //*/
            }
        }

        formatter.close();
    }
}
