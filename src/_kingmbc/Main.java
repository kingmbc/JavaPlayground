package _kingmbc;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main {
	public static void main(String args[]){
		Main m = new Main();
		System.out.println(m.plus());
		boolean a = true;
		String b = "kingmbc";
		m.convertValue(a);
		m.convertValue(b);

	}
	public void convertValue(Object value){
		if(value instanceof String){
			String a = (String)value;
			System.out.println(a);
		}else if(value instanceof Boolean){
			boolean b = (Boolean)value;
			System.out.println(b);
		}
	}
	public int plus(){
		int x = 0;
		Date now = new Date(System.currentTimeMillis());
		System.out.println("1.1: " + now.getTime());
		System.out.println("1.2: " + now);

		TimeZone kst = TimeZone.getTimeZone("Asia/Seoul");
		Calendar calendar = Calendar.getInstance(kst);
		Date time = calendar.getTime();
		System.out.println("2.1: " + time.getTime());
		System.out.println("2.2: " + time);

		final String DB_DATE_FORMAT = "yyyyMMddHHmmss.SSS";		//DB 안에서 Decimal(17,3) Format. Millisecond는 따로 존재
		SimpleDateFormat DB_FORMATTER = new SimpleDateFormat(DB_DATE_FORMAT);

		String currentTime = DB_FORMATTER.format(calendar.getTime());

		String TESTBED_DB_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";		//TESTBED 용
		SimpleDateFormat TESTBED_DB_FORMATTER = new SimpleDateFormat(TESTBED_DB_DATE_FORMAT);
		Date ddd = new Date(Long.valueOf("1480560461422"));
		System.out.println(TESTBED_DB_FORMATTER.format(ddd));

		System.out.println(currentTime);
		return (x = 1) + (x = 2);


	}
}
