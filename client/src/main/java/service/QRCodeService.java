package service;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modal.Computer;
import modal.GenerateQRCode;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class QRCodeService extends JFrame {
	private static final long serialVersionUID = 9022142288376442819L;
	private static final String remote = "remotebash-" + serialVersionUID;

	JFrame frame = new JFrame();
	JLabel title = new JLabel();
	JPanel panel = new JPanel();
	Computer pc = new Computer();
	Font fStandart = new Font("Helvetica Neue", Font.BOLD, 10);

	public void scrAutentic() {
		int scann = 1;
		if (scann == 0) {
			System.out.println("Não escaneado");
			scrQRCode();
		} else {
			System.out.println("Já escanneado");
			scrInfos();
		}

	}

	public void scrQRCode() {
		new GenerateQRCode(remote, pc.getSystem(), pc.getSerialNumber(), pc.getProcName(), pc.getTotal(), pc.getUsing(),
				pc.getAvaible(), pc.getVirtualMemory());

		frame.setSize(500, 500);
		frame.setTitle("QRCode do computador " + pc.getSerialNumber());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);

		title.setSize(500, 100);
		title.setText("Este computador ainda não foi registrado!");
		title.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		title.setLocation(40, 0);
		frame.add(title);

		ImageIcon icon = new ImageIcon("src/imgs/qrcode.png");
		JLabel qrcode = new JLabel(icon);
		qrcode.setSize(10, 10);
		qrcode.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		frame.add(qrcode);

		frame.setVisible(true);
	}

	public void scrInfos() {
		frame.setSize(500, 500);
		frame.setTitle("Computador " + pc.getSerialNumber() + " já registrado");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);

		title.setText(pc.getSystem() + "");
		title.setFont(fStandart);

		panel.setLayout(new GridBagLayout());

		GridBagConstraints ctr = new GridBagConstraints();
		ctr.anchor = GridBagConstraints.WEST;
		ctr.insets = new Insets(10, 10, 10, 10);

		ctr.gridx = 0;
		ctr.gridy = 1;
		panel.add(title, ctr);

		ctr.gridx = 0;
		ctr.gridy = 2;
		ctr.gridwidth = 2;
		ctr.anchor = GridBagConstraints.CENTER;
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Informações"));

		frame.add(panel);

		frame.setVisible(true);
	}
}
