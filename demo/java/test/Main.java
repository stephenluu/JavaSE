package test;

public class Main {

	public static void main(String[] args) {

		int n = 0;

		while (true) {

			if ((n - 1) % 5 == 0) {
				int n1 = (n - 1) / 5 * 4;

				if ((n1 - 1) % 5 == 0) {
					int n2 = (n1 - 1) / 5 * 4;

					if ((n2 - 1) % 5 == 0) {
						int n3 = (n2 - 1) / 5 * 4;

						if ((n3 - 1) % 5 == 0) {
							int n4 = (n3 - 1) / 5 * 4;

							if ((n4 - 1) % 5 == 0) {
								int n5 = (n4 - 1) / 5 * 4;

								if ((n5 - 1) % 5 == 0) {
									System.out.println("第一个符合要求的原来数目：" + n);
									System.out.println("第一晚到第五晚剩下的数目");
									System.out.println(n5 + "--" + n4 + "--"
											+ n3 + "--" + n2 + "--" + n1);
									break;
								}

							}

						}
					}

				}

			}

			n++;
		}

	}

}
