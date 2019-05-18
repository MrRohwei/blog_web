package com.looveh.blog_web.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author Looveh
 * @Date 2019/5/18/018 20:44
 * @Version 1.0
 * @Desc 验证码工具类
 **/
public class VerifyCodeUtil {

    private static final Logger LOG = LoggerFactory.getLogger(VerifyCodeUtil.class);

    public static final String VERIFY_SESSION_KEY = "session_verify_code";
    private static final String randString = "0123456789ABCKEFGHIJKLMNOPQRSTUVWXYZ";
    private int width = 100;
    private int height = 40;
    private int lineSize = 20;//干扰线数量
    private int codeLength = 4;

    private Random random = new Random();

    /**
     * 获得字体
     *
     * @return
     */
    private Font getFont() {
        return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
    }

    /**
     * 获得颜色
     *
     * @return
     */
    private Color getColor(int fc, int bc) {
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    public void getRandomCode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();//图片绘制工具
        g.fillRect(0, 0, width, height);//图片大小
        g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));//字体
        g.setColor(getColor(60, 113));//字体颜色
        //绘制干扰线
        for (int i = 0; i < lineSize; i++) {
            drawLine(g);
        }
        //绘制随机字符串
        String randomString = "";
        for (int i = 0; i < codeLength; i++) {
            randomString = drowString(g, randomString, i);
        }
        LOG.info("产生随机字符串为>>>>>>>>>>>{}", randomString);

        //将验证码保存到session
        session.removeAttribute(VERIFY_SESSION_KEY);
        session.setAttribute(VERIFY_SESSION_KEY, randomString);
        g.dispose();
        try {
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            LOG.error("验证码图片输出到客户端失败>>>>>>>>>>>>>>>>>>{}", e);
        }
    }

    /**
     * 绘制字符串
     *
     * @param g
     * @param randomString
     * @param i
     * @return
     */
    private String drowString(Graphics g, String randomString, int i) {
        g.setFont(getFont());
        g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
        String rand = getRandomString(random.nextInt(randString.length()));
        randomString += rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        int y = 10 + random.nextInt(20);
        g.drawString(rand, 5 + i * width / 4, y);
        return randomString;
    }

    /**
     * 绘制干扰线
     *
     * @param g
     */
    private void drawLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int x1 = random.nextInt(width);
        int y1 = random.nextInt(height);
        g.drawLine(x, y, x1, y1);
    }

    /**
     * 随机字符串
     *
     * @param num
     * @return
     */
    private String getRandomString(int num) {
        return String.valueOf(randString.charAt(num));
    }
}
