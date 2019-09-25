package service;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class QRCodeService extends JFrame {
	private static final long serialVersionUID = 9022142288376442819L;

	JFrame frame = new JFrame();

	public void fFrame(Integer id, String serial) {

		frame.setSize(500, 500);
		frame.setTitle("QRCode do computador N° " + id);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);

		JLabel qrcode = new JLabel();
		qrcode.setIcon(new ImageIcon("http://s.glbimg.com/jo/g1/f/original/2011/05/17/qrcode.jpg"));
		qrcode.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		qrcode.setBounds(10,10,10,10);
		qrcode.setOpaque(true);
		frame.add(qrcode);

		frame.setVisible(true);

	}
}
