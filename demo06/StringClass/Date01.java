package demo06.StringClass;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
G	Era 标志符	AD
y	年	2024, 24
M	月	July, 07
w	年中的周	27
W	月中的周	4
D	年中的天	189
d	月中的天	1-31
F	月中的星期	2
E	星期中的天的名字	Tuesday
u	星期中的天的号码 (1 = Monday)	1-7
a	上午/下午标记	PM
H	一天中的小时 (0-23)	0-23
k	一天中的小时 (1-24)	1-24
K	半天中的小时 (0-11)	0-11
h	半天中的小时 (1-12)	1-12
m	小时中的分钟	0-59
s	分钟中的秒	0-59
S	毫秒	0-999
z	时区	PST, GMT-08:00
Z	时区偏移	-0800
X	时区偏移	-08, -0800, -08:00
*/


public class Date01 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date.getTime()));
		System.out.println(date.getTime());

		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.getTime().getTime());

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		System.out.println(now.format(dateFormat));
	}
}
