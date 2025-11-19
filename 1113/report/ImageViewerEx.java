package kimhoon_report_20251115;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageViewerEx extends JFrame {

    // 선택한 이미지를 저장할 변수
    private BufferedImage selectedImage;

    // 이미지를 그릴 패널
    private DrawPanel drawPanel = new DrawPanel();

    public ImageViewerEx() {
        setTitle("이미지 뷰어 - drawImage 실습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);

        // 메뉴바 생성
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("파일");
        JMenuItem itemOpen = new JMenuItem("열기");

        // 메뉴 구성
        menuFile.add(itemOpen);
        menuBar.add(menuFile);
        setJMenuBar(menuBar);

        // 열기 메뉴 클릭 이벤트
        itemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openImage();
            }
        });

        // 패널 추가
        add(drawPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // 파일 열기 기능
    private void openImage() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "JPG Images", "jpg", "jpeg"));

        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            try {
                selectedImage = ImageIO.read(file);  // 이미지 로드
                drawPanel.repaint();                 // 화면 다시 그리기
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "이미지 로드 실패!");
            }
        }
    }

    // 이미지를 직접 그리는 패널
    class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 이미지가 선택된 경우만 그리기
            if (selectedImage != null) {
                g.drawImage(selectedImage, 
                            0, 0, getWidth(), getHeight(), 
                            null);
            }
        }
    }

    public static void main(String[] args) {
        new ImageViewerEx();
    }
}
