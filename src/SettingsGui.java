import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsGui {
    JButton applyButton;
    JFrame settingsFrame;
    JTextField heightText;
    JTextField widthText;
    JTextField expHeightText;
    JTextField expWidthText;
    JTextField checkIterText;
    JTextField expCheckIterText;
    JTextField backFadeText;
    JLabel emptyLabel;


    public void buildSettingsGui() {


        settingsFrame = new JFrame("SETTINGS");
        settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(8, 2);//stworzenie układu
        grid.setVgap(3);
        grid.setHgap(3);
        JPanel back = new JPanel(grid);
        back.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel heightLabel = new JLabel("Image height: ");
        JLabel widthLabel = new JLabel("Image width: ");
        JLabel expHeightLabel = new JLabel("Export image height: ");
        JLabel expWidthLabel = new JLabel("Export image width: ");
        JLabel checkIterLabel = new JLabel("Number of check iterations: ");
        JLabel expCheckIterLabel = new JLabel("Number of check iterations -export ");
        JLabel backFadeLabel = new JLabel("Min. satisfied iterations.: ");
        emptyLabel = new JLabel("");


        heightText = new JTextField();
        widthText = new JTextField();
        expHeightText = new JTextField();
        expWidthText = new JTextField();
        checkIterText = new JTextField();
        expCheckIterText = new JTextField();
        backFadeText = new JTextField();

        heightText.setText(String.valueOf(Parameters.getHeight()));
        widthText.setText(String.valueOf(Parameters.getWidth()));
        expHeightText.setText(String.valueOf(Parameters.getExportHeight()));
        expWidthText.setText(String.valueOf(Parameters.getExportWidth()));
        checkIterText.setText(String.valueOf(Parameters.getCheckIterations()));
        expCheckIterText.setText(String.valueOf(Parameters.getExportCheckIterations()));
        backFadeText.setText(String.valueOf(Parameters.getBackgroundFade()));



        applyButton = new JButton("APPLY");
        applyButton.addActionListener(new ApplyButtonListener());


        back.add(heightLabel);
        back.add(heightText);
        back.add(widthLabel);
        back.add(widthText);
        back.add(expHeightLabel);
        back.add(expHeightText);
        back.add(expWidthLabel);
        back.add(expWidthText);
        back.add(checkIterLabel);
        back.add(checkIterText);
        back.add(expCheckIterLabel);
        back.add(expCheckIterText);
        back.add(backFadeLabel);
        back.add(backFadeText);
        back.add(emptyLabel);
        back.add(applyButton);


        settingsFrame.setContentPane(back);

        settingsFrame.setResizable(false);

        settingsFrame.setPreferredSize(new Dimension(500, 300));
        settingsFrame.setBounds(50, 50, 300, 300);

        settingsFrame.pack();
        settingsFrame.setVisible(true);


    }


    public class ApplyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            try {

                int height = Integer.parseInt(heightText.getText());
                int width = Integer.parseInt(widthText.getText());
                int expHeight = Integer.parseInt(expHeightText.getText());
                int expWidth = Integer.parseInt(expWidthText.getText());
                int checkIter = Integer.parseInt(checkIterText.getText());
                int expCheckIter = Integer.parseInt(expCheckIterText.getText());
                int backFade = Integer.parseInt(backFadeText.getText());

                if (height > 20 && width > 350 && expHeight > 20 && expWidth > 20 && checkIter > 5 && expCheckIter > 5 && backFade >= 0) {
                    Parameters.setHeight(height);
                    Parameters.setWidth(width);
                    Parameters.setExportHeight(expHeight);
                    Parameters.setExportWidth(expWidth);
                    Parameters.setCheckIterations(checkIter);
                    Parameters.setExportCheckIterations(expCheckIter);
                    Parameters.setBackgroundFade(backFade);
                    settingsFrame.dispose();

                    ParallelImage startImage =new ParallelImage(Parameters.getWidth(), Parameters.getHeight(),
                            Parameters.getxMax(),Parameters.getiMax(), Parameters.getStep());
                    startImage.generateImage();

                    return;
                }
                emptyLabel.setText("WRONG PARAMETERS!");
                emptyLabel.setForeground(Color.RED);
                settingsFrame.repaint();
            } catch (Exception e) {
                heightText.setText(String.valueOf(Parameters.getHeight()));
                widthText.setText(String.valueOf(Parameters.getWidth()));
                expHeightText.setText(String.valueOf(Parameters.getExportHeight()));
                expWidthText.setText(String.valueOf(Parameters.getExportWidth()));
                checkIterText.setText(String.valueOf(Parameters.getCheckIterations()));
                expCheckIterText.setText(String.valueOf(Parameters.getExportCheckIterations()));
                backFadeText.setText(String.valueOf(Parameters.getBackgroundFade()));
                emptyLabel.setText("WRONG PARAMETERS!");
                emptyLabel.setForeground(Color.RED);




                settingsFrame.repaint();
                return;
            }


        }
    }
}




