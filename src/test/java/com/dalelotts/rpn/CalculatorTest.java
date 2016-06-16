package com.dalelotts.rpn;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

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
        final InputStream inStream = IOUtils.toInputStream("2 3 +", "UTF-8");
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
        assertThat(strings[2].toString(), equalTo("2"));
        assertThat(strings[3].toString(), equalTo("3"));
        assertThat(strings[4].toString(), equalTo("+"));
    }
}
