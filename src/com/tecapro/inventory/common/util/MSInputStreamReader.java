/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;

public class MSInputStreamReader extends InputStreamReader {

    /**
     * instance of InputStreamReader
     */
    private InputStreamReader reader = null;

    /**
     * init InputStreamReader with charsetName
     * @param in
     * @param charsetName
     * @throws UnsupportedEncodingException
     */
    public MSInputStreamReader(InputStream in, String charsetName) throws UnsupportedEncodingException {
        super(in, charsetName);
        reader = new InputStreamReader(in, charsetName);
    }

    /**
     * init InputStreamReader with Constants.Text.WINDOWS_31J
     * @param in
     */
    public MSInputStreamReader(InputStream in) {
        super(in);
        try {
            reader = new InputStreamReader(in, Constants.Text.WINDOWS_31J);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * close InputStreamReader
     */
    public void close() throws IOException {
        reader.close();
    }

    /**
     * compare InputStreamReader with object input
     */
    public boolean equals(Object arg0) {
        return reader.equals(arg0);
    }

    /**
     * get InputStreamReader encoding
     * @see java.io.InputStreamReader.getEncoding()
     */
    public String getEncoding() {
        return reader.getEncoding();
    }

    /**
     * @see java.lang.Object.hashCode()
     */
    public int hashCode() {
        return reader.hashCode();
    }

    /**
     * @see java.lang.Object.mark()
     */
    public void mark(int arg0) throws IOException {
        reader.mark(arg0);
    }

    /**
     * @see java.lang.Object.markSupported()
     */
    public boolean markSupported() {
        return reader.markSupported();
    }

    /**
     * @see java.lang.Object.read()
     */
    public int read() throws IOException {
        return reader.read();
    }

    /**
     * @see java.io.InputStreamReader.read(char[] cbuf, int offset, int length) throws IOException
     */
    public int read(char[] cbuf, int offset, int length) throws IOException {
        return reader.read(cbuf, offset, length);
    }

    /**
     * @see java.io.Reader.read(char[] cbuf) throws IOException
     */
    public int read(char[] arg0) throws IOException {
        return reader.read(arg0);
    }

    /**
     * @see java.io.Reader.read(CharBuffer target) throws IOException
     */
    public int read(CharBuffer arg0) throws IOException {
        return reader.read(arg0);
    }

    /**
     * @see java.io.InputStreamReader.ready() throws IOException
     */
    public boolean ready() throws IOException {
        return reader.ready();
    }

    /**
     * @see java.io.Reader.reset() throws IOException
     */
    public void reset() throws IOException {
        reader.reset();
    }

    /**
     * @see java.io.Reader.skip(long n) throws IOException
     */
    public long skip(long arg0) throws IOException {
        return reader.skip(arg0);
    }

    /**
     * @see java.lang.Object.toString()
     */
    public String toString() {
        return reader.toString();
    }

}