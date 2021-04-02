package JieZhong.util;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public  class CommUtils {

    /**
     *
     * toJP方法：汉字转成简拼 <br/>
     * <br/>
     *
     * @param c
     * @return
     * @exception
     */
    public static String toJianPin(String c) {

        char[] chars = c.toCharArray();

        StringBuffer sb = new StringBuffer("");

        for (int i = 0; i < chars.length; i++) {
            sb.append(getJP(chars[i]));
        }
        String aa = sb.toString();
        return aa.toUpperCase();
    }
    public static String getJP(char c) {
        byte[] array = new byte[2];
        try {
            array = String.valueOf(c).getBytes("gbk");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (array.length < 2)
            return String.valueOf(c);
        int i = (short) (array[0] + 256) * 256 + ((short) (array[1] + 256));
        if (i < 0xB0A1)
            return String.valueOf(c);
        if (i < 0xB0C5)
            return "a";
        if (i < 0xB2C1)
            return "b";
        if (i < 0xB4EE)
            return "c";
        if (i < 0xB6EA)
            return "d";
        if (i < 0xB7A2)
            return "e";
        if (i < 0xB8C1)
            return "f";
        if (i < 0xB9FE)
            return "g";
        if (i < 0xBBF7)
            return "h";
        if (i < 0xBFA6)
            return "j";
        if (i < 0xC0AC)
            return "k";
        if (i < 0xC2E8)
            return "l";
        if (i < 0xC4C3)
            return "m";
        if (i < 0xC5B6)
            return "n";
        if (i < 0xC5BE)
            return "o";
        if (i < 0xC6DA)
            return "p";
        if (i < 0xC8BB)
            return "q";
        if (i < 0xC8F6)
            return "r";
        if (i < 0xCBFA)
            return "s";
        if (i < 0xCDDA)
            return "t";
        if (i < 0xCEF4)
            return "w";
        if (i < 0xD1B9)
            return "x";
        if (i < 0xD4D1)
            return "y";
        if (i < 0xD7FA)
            return "z";
        return String.valueOf(c);

    }
    /**
     * base64字符串转换成图片
     * @param imgStr
     * @param path
     * @return
     */
    public static boolean generateImage(String imgStr, String path) {
        if (imgStr == null)
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(imgStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(path);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * base64编码字符串转换为图片
     * @param imgStr base64编码字符串
     * @param path 图片路径
     * @return
     */
    public static boolean base64StrToImage(String imgStr, String path) {
        if (imgStr == null)
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(imgStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            //文件夹不存在则自动创建
            File tempFile = new File(path);
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(tempFile);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
