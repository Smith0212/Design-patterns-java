import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ObesityView extends JFrame {
    private JTextField weightField, heightField, bmiField;
    private JButton calculateButton;

    public ObesityView() {
        super("BMI Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize GUI components
        weightField = new JTextField(20);
        heightField = new JTextField(20);
        bmiField = new JTextField(20);
        bmiField.setEditable(false);
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText());
                ObesityModel model = new ObesityModel();
                model.setWeight(weight);
                model.setHeight(height);
                model.calculateBMI();
                bmiField.setText(Double.toString(model.getBMI()));
            }
        });

        // Add GUI components to window
        JPanel contentPane = new JPanel(new GridLayout(4, 10));
        contentPane.add(new JLabel("Weight (kg): "));
        contentPane.add(weightField);
        contentPane.add(new JLabel("Height (m): "));
        contentPane.add(heightField);
        contentPane.add(new JLabel("BMI: "));
        contentPane.add(bmiField);
        JPanel buttonPane = new JPanel(new FlowLayout());
        buttonPane.add(calculateButton);
        getContentPane().add(contentPane, BorderLayout.CENTER);
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        // Display window
        pack();
        setVisible(true);
    }
}

class ObesityModel {
    private double weight;
    private double height;
    private double bmi;

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void calculateBMI() {
        this.bmi = weight / (height * height);
    }

    public double getBMI() {
        return this.bmi;
    }
}

class ObesityController {
    private ObesityModel model;
    private ObesityView view;

    public ObesityController(ObesityModel model, ObesityView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        // No need to do anything here for this implementation
    }
}

public class MVC {
    public static void main(String[] args) {
        ObesityModel model = new ObesityModel();
        ObesityView view = new ObesityView();
        ObesityController controller = new ObesityController(model, view);
        controller.start();
    }
}
