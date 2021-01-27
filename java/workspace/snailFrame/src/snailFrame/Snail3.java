package snailFrame;

import java.util.Random;

public class Snail3 implements Runnable{
	Random r = new Random();

	@Override
	public void run() {
		for (int j = 0; j < 20; j++) {
			long time = r.nextInt(901) + 100;
			String text = "";
			text += "¡Ú" + "3¹ø ´ÞÆØÀÌ";
			for (int l = 0; l < j; l++) {
				text += "  ";
			}
			text += "@_¨¬¬Õ¨¬";
			for (int m = 0; m < 20 - j; m++) {
				text += ("  ");
			}
			text += "¢Ò";
			SnailMain.snail3.setText(text);
			SnailMain.sv.revalidate();
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
			}
		}
	}
}
