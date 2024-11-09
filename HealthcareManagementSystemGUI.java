import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthcareManagementSystemGUI extends JFrame {
    private JTextField patientNameField;
    private JTextField patientAgeField;
    private JTextField appointmentDateField;
    private JTextArea outputArea;

    public HealthcareManagementSystemGUI() {
        setTitle("Online Healthcare Management System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JLabel nameLabel = new JLabel("Patient Name:");
        patientNameField = new JTextField(20);
        JLabel ageLabel = new JLabel("Patient Age:");
        patientAgeField = new JTextField(3);
        JButton registerButton = new JButton("Register Patient");

        // Appointment Scheduling
        JLabel appointmentLabel = new JLabel("Appointment Date (YYYY-MM-DD):");
        appointmentDateField = new JTextField(10);
        JButton scheduleButton = new JButton("Schedule Appointment");

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add components to the frame
        add(nameLabel);
        add(patientNameField);
        add(ageLabel);
        add(patientAgeField);
        add(registerButton);
        add(appointmentLabel);
        add(appointmentDateField);
        add(scheduleButton);
        add(scrollPane);

        // Button Actions
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerPatient();
            }
        });

        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleAppointment();
            }
        });
    }

    private void registerPatient() {
        String name = patientNameField.getText();
        String age = patientAgeField.getText();
        if (!name.isEmpty() && !age.isEmpty()) {
            outputArea.append("Registered Patient: " + name + ", Age: " + age + "\n");
            patientNameField.setText("");
            patientAgeField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void scheduleAppointment() {
        String date = appointmentDateField.getText();
        if (!date.isEmpty()) {
            outputArea.append("Scheduled Appointment on: " + date + "\n");
            appointmentDateField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter an appointment date.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HealthcareManagementSystemGUI hms = new HealthcareManagementSystemGUI();
            hms.setVisible(true);
        });
    }
}
