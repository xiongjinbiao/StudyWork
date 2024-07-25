package demo09.upload;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
 
public class StreamUtils {
	
	/**
	 * 将输入流全部读取完，并保存到一个字节数组中
	 * @param is 输入流
	 * @return 输入流转换成的字节数组
	 * @throws Exception
	 */
    public static byte[] streamToByteArray(InputStream is) throws Exception {
        // 创建输出流对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 字节数组
        byte[] b = new byte[1024];
        int len;
        while ((len = is.read(b)) != -1) {
            // 循环读取
            // 把读取到的数据，写入 bos
            bos.write(b, 0, len);
        }
        byte[] array = bos.toByteArray();
        bos.close();
        return array;
    }
 
    /**
     * 将输入流全部读取完，并保存到一个字符串中
     * @param is 输入流
     * @return 输入流转换成的字符串
     * @throws Exception
     */
    public static String streamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line + "\r\n");
        }
        return builder.toString();
    }
    
}

