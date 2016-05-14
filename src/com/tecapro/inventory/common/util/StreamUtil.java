/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

/**
 * Stream util class
 *
 */
@Component("StreamUtil")
public class StreamUtil {

    
    public void copyStream(InputStream istream, OutputStream ostream) throws IOException {

        BufferedInputStream ibstream = null;
        BufferedOutputStream obstream = null;

        try {
            ibstream = new BufferedInputStream(istream);
            obstream = new BufferedOutputStream(ostream);

            byte[] buff = new byte[4096];
            int length = 0;
            while ((length = ibstream.read(buff, 0, buff.length)) > -1) {
                obstream.write(buff, 0, length);
            }
        } finally {
            try {
                if (ibstream != null) {
                    ibstream.close();
                }
            } finally {
                if (obstream != null) {
                    obstream.close();
                }
            }
        }
    }

}
