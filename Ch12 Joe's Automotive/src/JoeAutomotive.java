//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//
///**
// * @author Dolunay Dagci
// * 2.24.18
// * Assignment: Ch12 Joe's Automotive
// * CISS111-360
// * This program does following maintanence services:
// *
// * -Oil change $26.00
// * -Lube Job 18.00
// * Radiator Flush 30.00
// * Transmission Flush 80.00
// * Inspection 15.00
// * Muffler Replacement 100.00
// * Tire Rotation 20.00
// * Other non-routine services -for parts and labor - 20/hour
// * display total for a cuustomer's visit to Joe's
// */
//
//public class JoeAutomotive extends JFrame {
//
//    private JTextField hoursField;
//    private JCheckBox oilChange;
//    private JCheckBox lubeJob;
//    private JCheckBox radiatorFlush;
//    private JCheckBox transmissionFlush;
//    private JCheckBox inspection;
//    private JCheckBox mufflerReplace;
//    private JCheckBox tireRotation;
//    private JCheckBox otherServices;
//
//    public JoeAutomotive() {
//
//        setTitle("Joe's Automotive Services");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
//        JPanel jPanel = new JPanel();
//        JPanel optionPanel = new JPanel();
//
//        oilChange = new JCheckBox("Oil Change($26.00)");
//        lubeJob	= new JCheckBox("Lube job($18.00)");
//        radiatorFlush = new JCheckBox("Radiator flush($30.00)");
//        transmissionFlush = new JCheckBox("Transmission flush($80.00)");
//        inspection = new JCheckBox("Inspection($15.00)");
//        mufflerReplace = new JCheckBox("Muffler replacement($100.00)");
//        tireRotation = new JCheckBox("Tire rotation($20.00)");
//        otherServices = new JCheckBox("Non-routine services: Hours");
//        hoursField = new JTextField(3);
//        JButton button1 = new JButton("Total");
//
//        button1.addActionListener(new DD_ButtonListener());
//
//
//        optionPanel.add(oilChange);
//        optionPanel.add(lubeJob);
//        optionPanel.add(radiatorFlush);
//        optionPanel.add(transmissionFlush);
//
//        optionPanel.add(inspection);
//        optionPanel.add(mufflerReplace);
//        optionPanel.add(tireRotation);
//        optionPanel.add(otherServices);
//        optionPanel.add(hoursField);
//        jPanel.add(button1);
//
//        optionPanel.setBackground(Color.DARK_GRAY);
//
//
//        add(jPanel, BorderLayout.SOUTH);		// Add the panel to the content pane.
//        add(optionPanel, BorderLayout.WEST);
//        pack();				// Automatically set the size of the window
//        setVisible(true);
//    }
//
//    private class DD_ButtonListener implements ActionListener {
//
//        double non_routine_serviceCost;
//        double total = 0;
//        String input;
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//            if ( oilChange.isSelected()) {
//                total += 26;}
//            if ( lubeJob.isSelected()){
//                total += 18;}
//            if ( radiatorFlush.isSelected()){
//                total += 30;}
//            if ( transmissionFlush.isSelected()){
//                total += 80;}
//            if ( inspection.isSelected()){
//                total += 15;}
//            if ( mufflerReplace.isSelected()){
//                total += 100;}
//            if ( tireRotation.isSelected()){
//                total += 20;}
//            if ( otherServices.isSelected())
//            {
//                input = hoursField.getText();
//                non_routine_serviceCost = Double.parseDouble(input) * 20;
//                total += non_routine_serviceCost;
//            }
//            JOptionPane.showMessageDialog(null, "Total: $" + total);
//        }
//
//    }
//    public static void main(String[] args){
//        new JoeAutomotive();
//    }
//
//
//}
//
//
