
public class time {

	public static void main(String[] args) throws java.lang.Exception {
		long start, stop, elapsed;
		start = System.currentTimeMillis();
		System.out.println(start);
		for (int i = 0; i < 7000000; i++) {
			System.out.println(i);
		}
		stop = System.currentTimeMillis();
		System.out.println(stop);

		System.out.println("Elapsed time in seconds: ");
		elapsed = (start - stop) / 1000;
		System.out.println(elapsed);
	}

}
