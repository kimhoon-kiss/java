
package kimhoon_report_20251120;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
// ----------------------------------------------------------------------
import java.net.URL; // 👈 URL 타입 사용을 위해 이 import 문을 추가했습니다.
// ----------------------------------------------------------------------

public class ImageTogglePanel extends JPanel {
    private Image backgroundImage;
    private boolean showImage = true;

    public ImageTogglePanel() {
        setLayout(new FlowLayout());

        // 이미지 로드
        // 클래스패스 루트(/)에서 back.jpg 파일을 찾습니다.
        // C:\java\workspace\report_\src 경로에 back.jpg가 있다고 가정합니다.
        URL imageUrl = getClass().getResource("/back.jpg"); 
        
        if (imageUrl == null) {
            JOptionPane.showMessageDialog(this, "이미지 파일(back.jpg)을 'src' 폴더에서 찾을 수 없습니다.", "파일 없음", JOptionPane.ERROR_MESSAGE);
            System.err.println("오류: back.jpg 파일을 C:\\java\\workspace\\report_\\src 경로에 직접 배치했는지 확인하세요.");
            // 오류 발생 시 강제 종료 대신, 단순히 이미지 로드를 실패한 상태로 진행
            // System.exit(1); 
        } else {
            try {
                // URL을 통해 이미지를 읽습니다.
                backgroundImage = ImageIO.read(imageUrl);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "이미지 파일을 읽는 중 오류 발생: " + e.getMessage(), "IO 오류", JOptionPane.ERROR_MESSAGE);
                // System.exit(1);
            }
        }

        JButton toggleButton = new JButton("Hide/Show");
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showImage = !showImage;
                repaint();  // 버튼 클릭 시 repaint() 호출하여 이미지 다시 그림
            }
        });

        add(toggleButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (showImage && backgroundImage != null) {
            // 이미지를 패널 크기에 맞게 그립니다.
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("이미지 토글 데모");
            ImageTogglePanel panel = new ImageTogglePanel();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}