package com.twu.biblioteca;

import java.io.IOException;

public interface ConsoleWrapper {
    void println(String str);
    int getInteger() throws IOException;
    String getInput() throws IOException;
    String getOutput();
    void setInput(String str);
}
