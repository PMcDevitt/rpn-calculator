package com.dalelotts.rpn;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.apache.commons.io.IOUtils.toInputStream;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dale "Ducky" Lotts
 * @since 10/27/15.
 */

public class CalculatorTest {

    private Calculator calculator;

    @Test
    public void runShouldDoTheRightThing() throws IOException {
        // Given
        final InputStream inStream = toInputStream("2 3 +", "UTF-8");
        final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(outStream);

        calculator = new Calculator(new Scanner(inStream), printStream);

        // When
        calculator.run();
        final String[] strings = outStream.toString().split("\n");
        // Then
        // How can we make sure the calculator did the right thing?
        assertThat(strings[0].toString(), equalTo("Please enter values followed by operation symbols:"));
        assertThat(strings[1].toString(), equalTo("(Press CTRL+Z to end the program):"));

    }

    @Test
    public void addTwoNumbersTogether() throws IOException {
        final InputStream inStream = toInputStream("3 3 +", "UTF-8");
        final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(outStream);

        new Calculator(new Scanner(inStream), printStream).run();
        final String[] strings = outStream.toString().split("\n");
        assertThat(strings[2].toString(), equalTo("6"));

        final InputStream inStreamA = toInputStream("7 3 +", "UTF-8");
        final ByteArrayOutputStream outStreamA = new ByteArrayOutputStream();
        final PrintStream printStreamA = new PrintStream(outStreamA);

        new Calculator(new Scanner(inStreamA), printStreamA).run();
        final String[] stringsA = outStreamA.toString().split("\n");
        assertThat(stringsA[2].toString(), equalTo("10"));
    }

    @Test
    public void subtractANumberFromAnotherNumber() throws IOException {
        final InputStream inStream = toInputStream("3 3 -", "UTF-8");
        final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(outStream);

        new Calculator(new Scanner(inStream), printStream).run();
        final String[] strings = outStream.toString().split("\n");
        assertThat(strings[2].toString(), equalTo("0"));

        final InputStream inStreamA = toInputStream("7 3 -", "UTF-8");
        final ByteArrayOutputStream outStreamA = new ByteArrayOutputStream();
        final PrintStream printStreamA = new PrintStream(outStreamA);

        new Calculator(new Scanner(inStreamA), printStreamA).run();
        final String[] stringsA = outStreamA.toString().split("\n");
        assertThat(stringsA[2].toString(), equalTo("4"));
    }

    @Test
    public void multiplyTwoNumbersTogether() throws IOException {

        final InputStream inStream = toInputStream("3 3 *", "UTF-8");
        final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(outStream);

        new Calculator(new Scanner(inStream), printStream).run();
        final String[] strings = outStream.toString().split("\n");
        assertThat(strings[2].toString(), equalTo("9"));

        final InputStream inStreamA = toInputStream("7 3 *", "UTF-8");
        final ByteArrayOutputStream outStreamA = new ByteArrayOutputStream();
        final PrintStream printStreamA = new PrintStream(outStreamA);

        new Calculator(new Scanner(inStreamA), printStreamA).run();
        final String[] stringsA = outStreamA.toString().split("\n");
        assertThat(stringsA[2].toString(), equalTo("21"));
    }

    @Test
    public void divideOneNumberByAnother() throws IOException {
        final InputStream inStream = toInputStream("3 3 /", "UTF-8");
        final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(outStream);

        new Calculator(new Scanner(inStream), printStream).run();
        final String[] strings = outStream.toString().split("\n");
        assertThat(strings[2].toString(), equalTo("1"));

        final InputStream inStreamA = toInputStream("27 9 /", "UTF-8");
        final ByteArrayOutputStream outStreamA = new ByteArrayOutputStream();
        final PrintStream printStreamA = new PrintStream(outStreamA);

        new Calculator(new Scanner(inStreamA), printStreamA).run();
        final String[] stringsA = outStreamA.toString().split("\n");
        assertThat(stringsA[2].toString(), equalTo("3"));
    }
}
