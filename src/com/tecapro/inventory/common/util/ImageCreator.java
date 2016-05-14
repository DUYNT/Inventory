package com.tecapro.inventory.common.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author duynt
 * @version 1.0
 */
public class ImageCreator extends HttpServlet {
    private static final long serialVersionUID = -1761346889117186607L;

    // private ImageFilter[] filters;

    /*
     * static {
     * 
     * }
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_BYTE_INDEXED);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 200, 40);

        GradientPaint gradientPaint = new GradientPaint(5, 5, Color.BLACK, 20, 10, Color.BLACK, true);
        graphics.setPaint(gradientPaint);

        Font font = new Font(null, Font.PLAIN, 20);

        // write
        String textCaptchar = PasswordUtil.generateRandomString(6);
        request.getSession().setAttribute("captchar", textCaptchar);
        AffineTransform affineTransform = AffineTransform.getTranslateInstance(0, 0);
        affineTransform.rotate(Math.toRadians(2), Math.random(), Math.random());
        affineTransform.concatenate(affineTransform);
        double[] doi = { 12, 30, 14, 40, 9 };
        affineTransform.getMatrix(doi);
        try {
            affineTransform.createInverse();
        } catch (NoninvertibleTransformException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Font rotatedFont = font.deriveFont(affineTransform);
        graphics.setFont(rotatedFont);

        graphics.drawString(textCaptchar, 5, 23);
        graphics.dispose();

        response.setContentType("image/jpg");
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.close();
    }

}
