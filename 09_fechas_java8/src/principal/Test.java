package principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Test {

	public static void main(String[] args) {
		LocalDate l1=LocalDate.now();
		LocalDate l2=LocalDate.of(2016, 10, 6);
		System.out.println(l2);
		//LocalDate l3=LocalDate.parse("2010-3-15");
		//System.out.println(l3);
		//System.out.println(l3.plusMonths(10));//<-Devuelve una copia de l3
		//System.out.println(l1.plus(24,ChronoUnit.HOURS));
		LocalTime lt1=LocalTime.of(10, 20,30);
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(ldt);
		System.out.println(ldt.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(ldt.format(DateTimeFormatter.ISO_DATE));
		System.out.println(ldt.format(DateTimeFormatter.ISO_DATE_TIME));
		
		LocalDateTime ldt2=LocalDateTime.of(2017,10,20,20,35,40);
		//Para sacarlo con el formato 18/10/20 -08:35:40
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd - hh:mm:ss");
		System.out.println(ldt2.format(dtf));
		
		System.out.print(ldt2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT,FormatStyle.SHORT)));
	}

}
