public class Base64v2Test {

	public static void main(String[] args) {
		String testString = "This is a test!";

		String enc, dec, enc2, dec2;

		while (testString.length() > 0) {
			System.out.print(testString + " -> ");

			// test a clean encoding / decoding
			enc = Base64v2.encode(testString);
			dec = Base64v2.decodeToString(enc, false);

			System.out.print(" " + enc + " -> " + dec);

			// test a dirty encoding / decoding
			if (enc.length() > 5) enc2 = "\t" + enc.substring(0, 5) + " : " + enc.substring(5) + "###";
			else enc2 = "\t" + enc + "###";
			dec2 = Base64v2.decodeToString(enc2, true);

			System.out.print(" " + enc2 + " -> " + dec2);

			// compare to original string and output result
			System.out.print(" " + (dec.equals(testString) ? "[Match]" : "[ERROR]"));
			System.out.println(" " + (dec2.equals(testString) ? "[Match]" : "[ERROR]"));

			testString = testString.substring(1);
		}


		System.out.println("Now:");
		System.out.println("\t"+System.currentTimeMillis());
		String now = Base64v2.encodeNow(); // FYI: may be off by a millisecond from the last output
		System.out.println("\t"+now);
		System.out.println("\t"+Base64v2.decodeTime(now, false));
	}

}
