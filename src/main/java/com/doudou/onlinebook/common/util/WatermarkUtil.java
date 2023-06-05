package com.doudou.onlinebook.common.util;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author ：zhuyk
 * @date ：Created in 2023-6-2 16:05
 * @modified By：图片水印
 * @version: 1.0.0$
 */
@Slf4j
public class WatermarkUtil {



        /**
         * 添加图片水印
         *
         * @param iconPath   水印图片地址
         * @param srcImgPath 背景图片地址
         * @param targerPath 输出图片地址
         * @param degree     水印旋转角度，比如：-45，逆时针旋转45度
         */
        public static void ImageWatermark(String iconPath, String srcImgPath, String targerPath, Integer degree) {
            OutputStream os = null;
            try {
                Image srcImg = ImageIO.read(new File(srcImgPath));

                BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

                // 得到画笔对象
                Graphics2D g = buffImg.createGraphics();

                // 设置对线段的锯齿状边缘处理
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);

                if (null != degree) {
                    // 设置水印旋转
                    g.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
                }

                // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度
                ImageIcon imgIcon = new ImageIcon(iconPath);

                // 得到Image对象。
                Image img = imgIcon.getImage();
                // 透明度
                float alpha = 0.5f;
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

                // 表示水印图片的位置
                g.drawImage(img, 150, 300, null);

                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

                // 文字水印
//            // new Font("字体","字体风格","字体大小")
//            g.setFont(new Font("宋体", Font.ITALIC, 30));
//            // 设置字体颜色
//            g.setColor(Color.red);
//            //第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y)
//            g.drawString("http://www.myqxin.com", 100, 300);

                g.dispose();

                os = new FileOutputStream(targerPath);

                // 生成图片
                ImageIO.write(buffImg, "JPG", os);
                log.info("图片水印添加成功。。。。。。");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != os)
                        os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        /**
         * 添加文字水印
         *
         * @param context    文字内容
         * @param font       字体风格对象 new Font("文字主题","文字样式",文字大小)
         * @param srcImgPath 背景图片地址
         * @param targerPath 输出图片地址
         * @param degree     水印旋转角度，比如：45，顺时针旋转45度
         */
        public static void WritingWatermark(String context, Font font, String srcImgPath, String targerPath, Integer degree) {
            OutputStream os = null;
            try {
                Image srcImg = ImageIO.read(new File(srcImgPath));

                BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

                // 得到画笔对象
                Graphics2D g = buffImg.createGraphics();

                // 设置对线段的锯齿状边缘处理
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);

                if (null != degree) {
                    // 设置水印旋转
                    g.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
                }

                // 透明度
                float alpha = 0.5f;
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

                // 文字水印
                g.setFont(font);
                // 设置字体颜色
                g.setColor(Color.red);
                //第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y)
                g.drawString(context, 100, 300);

                g.dispose();

                os = new FileOutputStream(targerPath);

                // 生成图片
                ImageIO.write(buffImg, "JPG", os);
                log.info("文字水印添加成功。。。。。。");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != os)
                        os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }




}
