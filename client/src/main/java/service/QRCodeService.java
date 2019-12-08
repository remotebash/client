package service;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import helpers.ComputerHelper;
import modal.Computer;
import modal.GenerateQRCode;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QRCodeService extends JFrame {
	private static final long serialVersionUID = 9022142288376442819L;
	private static final String remote = "remotebash";

	JFrame frame = new JFrame();
	JFrame frameQ = new JFrame();

	JLabel title = new JLabel();
	JPanel panel = new JPanel();

	Font fStandart = new Font("Helvetica Neue", Font.BOLD, 13);
	Font fTitle = new Font("Helvetica Neue", Font.BOLD, 18);

	public JFrame scrQRCode() {
		Computer pc = ComputerHelper.getComputer();
		new GenerateQRCode(remote, pc);

		frameQ.setSize(500, 500);
		frameQ.setTitle("QRCode do computador " + pc.getMacaddress());
		frameQ.setLocationRelativeTo(null);
		frameQ.getContentPane().setBackground(Color.white);

		title.setSize(500, 100);
		title.setText("Este computador ainda não foi registrado!");
		title.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		title.setLocation(40, 0);
		frameQ.add(title);

		ImageIcon icon = new ImageIcon("src/imgs/qrcode.png");
		JLabel qrcode = new JLabel(icon);
		qrcode.setSize(10, 10);
		qrcode.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		frameQ.add(qrcode);

		return frameQ;
	}

	public JFrame scrInfos() {
		Computer pc = ComputerHelper.getComputer();
		frame.setSize(550, 300);
		frame.setTitle("Computador " + pc.getMacaddress() + " já registrado");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);

		title.setText("Este computador já foi registrado");
		title.setFont(fTitle);

		JLabel system = new JLabel("\nSistema: " + pc.getOperationalSystem());
		system.setFont(fStandart);

		JLabel processor = new JLabel("\nProcessador: " + pc.getProcessorModel());
		processor.setFont(fStandart);

		JLabel ramTotal = new JLabel("\nRAM: " + pc.getRamMemory() + "GB");
		ramTotal.setFont(fStandart);

		JLabel hdTotal = new JLabel("\nHD: " + pc.getHdUsage());
		hdTotal.setFont(fStandart);

		JLabel ip = new JLabel("\nIP: " + pc.getIp());
		ip.setFont(fStandart);

		JLabel mac = new JLabel("\nMAC: " + pc.getMacaddress());
		mac.setFont(fStandart);

		panel.setLayout(new GridBagLayout());

		GridBagConstraints ctr = new GridBagConstraints();
		ctr.insets = new Insets(20, 20, 20, 20);

		ctr.gridx = 0;
		ctr.gridy = 1;
		panel.add(title, ctr);

		ctr.insets = new Insets(2, 2, 2, 2);

		ctr.gridx = 0;
		ctr.gridy = 2;
		panel.add(system, ctr);

		ctr.gridx = 0;
		ctr.gridy = 3;
		panel.add(processor, ctr);

		ctr.gridx = 0;
		ctr.gridy = 4;
		panel.add(ramTotal, ctr);

		ctr.gridx = 0;
		ctr.gridy = 5;
		panel.add(hdTotal, ctr);

		ctr.gridx = 0;
		ctr.gridy = 6;
		panel.add(mac, ctr);

		ctr.gridx = 0;
		ctr.gridy = 7;
		panel.add(ip, ctr);

		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Informações"));

		frame.add(panel);

		return frame;
	}

	public void scrTray() {

		SystemTray sysTray = SystemTray.getSystemTray();
		Image img = Toolkit.getDefaultToolkit().createImage("src/imgs/iconTray.png");
		PopupMenu sysMenu = new PopupMenu();
		TrayIcon trayIcon = new TrayIcon(img, "Remote Bash - Client", sysMenu);

		MenuItem about = new MenuItem("About...");
		MenuItem sair = new MenuItem("Exit");

		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
			}
		});

		sysMenu.add(about);
		sysMenu.addSeparator();
		sysMenu.add(sair);

		try {
			sysTray.add(trayIcon);
		} catch (AWTException e) {
			System.out.println("System Tray não suportada!");
		}
	}
}
