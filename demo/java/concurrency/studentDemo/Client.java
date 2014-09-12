package concurrency.studentDemo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class Client {

	private final static int N_THREADS = 4;

	public static void main(String[] args) throws InterruptedException {

		final Queue<Student> quque = new LinkedList<Student>();
		for (int i = 0; i < 20; i++) {
			quque.add(new Student(i, "student" + i));// 初始化...形式可变
		}
		final StringBuffer sb = new StringBuffer();

		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(N_THREADS);

		for (int i = 0; i < N_THREADS; i++) {
			new Thread() {
				public void run() {
					try {
						startGate.await();
						while (true) {
							synchronized (quque) {

								if (!quque.isEmpty())
									sb.append(quque.poll() + "\n");
								else
									break;
							}
						}

					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						endGate.countDown();
					}
				};
			}.start();
		}

		startGate.countDown();
		endGate.await();
		System.out.println(sb.toString());// 把字符串 IO写入即可

	}
}

class Student {

	private final int id;
	private final String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
